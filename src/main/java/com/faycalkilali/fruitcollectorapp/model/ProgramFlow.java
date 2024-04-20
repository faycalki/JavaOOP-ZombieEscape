package com.faycalkilali.fruitcollectorapp.model;


/**
 * The first model object to be created in the MVC-Architecture. Entry-point for the creation of the rest of the Model.
 * Performs logical manipulation or requisition of the data when commanded to by the Controller.
 *
 * @author Faycal Kilali
 * @version 1.1
 */

public class ProgramFlow implements IProgramFlow {

    private final IGrid grid;
    private boolean gameInProgress;
    private boolean gameWon;

    private static final int GAME_OVER_HEALTH = 0;
    private static final int DAMAGE_FROM_ZOMBIE = 5;
    private static final int FRUIT_HEALTH_GAIN = 10;
    private static final double CHANCE_OF_ZOMBIE_NOT_MOVING = 0.25;
    private static int highScore = 0;
    private int score = 0;


    /**
     * Constructor for the program flow.
     */
    public ProgramFlow() {
        grid = new Grid();
        this.gameInProgress = false;
        this.gameWon = false;
    }


    /**
     * Updates state of Zombies.
     */
    @Override
    public void update() {
        // Is Barbie next to some zombie? If she is, lose 5 health per adjacent zombie tile
        checkBarbieAdjacentToZombie();

        // Move zombies randomly
        moveZombiesRandomly();
    }

    /**
     * Checks if Barbie is adjacent to any zombies and reduces her health by 5 per zombie that's adjacent.
     */
    private void checkBarbieAdjacentToZombie() {
        for (int row = 0; row < grid.getNumberOfRows(); row++) {
            for (int column = 0; column < grid.getNumberOfColumns(); column++) {
                // Check if Barbie is adjacent to the zombie
                if (grid.getGrid()[row][column] instanceof Zombie && isBarbieAdjacent(row, column)) {
                    Barbie barbie = grid.getBarbie();
                    barbie.setHealth(barbie.getHealth() - DAMAGE_FROM_ZOMBIE);
                    if (barbie.getHealth() <= GAME_OVER_HEALTH) {
                        swapGameInProgress();
                        gameWon = false;
                        score = 0;
                        barbie.resetToDefault();
                    }
                }
            }
        }
    }


    /**
     * Checks if Barbie is adjacent to a zombie.
     *
     * @param zombieRow    row of zombie.
     * @param zombieColumn column of zombie.
     * @return true if she is adjacent to a zombie, false otherwise.
     */
    private boolean isBarbieAdjacent(int zombieRow, int zombieColumn) {
        // We'll check each adjacent cell
        for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
            for (int colOffset = -1; colOffset <= 1; colOffset++) {
                int adjacentRow = zombieRow + rowOffset;
                int adjacentCol = zombieColumn + colOffset;

                // Ensure the adjacent cell is within the grid boundaries
                if (isValidCell(adjacentRow, adjacentCol)) {
                    // Check if Barbie is in the adjacent cell
                    if (grid.getBarbieRow() == adjacentRow && grid.getBarbieColumn() == adjacentCol) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks if a cell is not outside grid boundaries.
     *
     * @param row    of cell.
     * @param column of cell.
     * @return true if it is valid to move to cell, false otherwise.
     */
    private boolean isValidCell(int row, int column) {
        if (row < 0 || row >= grid.getNumberOfRows() || column < 0 || column >= grid.getNumberOfColumns()) {
            return false; // Outside the grid boundaries
        }
        return true;
    }

    /**
     * Checks if a cell is valid for movement towards.
     *
     * @param row    of cell.
     * @param column of cell.
     * @return true if it is valid to move to cell, false otherwise.
     */
    private boolean isValidMove(int row, int column) {
        // Don't overwrite any of those instances (can't walk into them)
        return !(grid.getGrid()[row][column] instanceof Person) &&
                !(grid.getGrid()[row][column] instanceof Wall) &&
                !(grid.getGrid()[row][column] instanceof Zombie);
    }


    /**
     * Enforces a random chance of a zombie moving.
     */
    private void moveZombiesRandomly() {
        for (int row = 0; row < grid.getNumberOfRows(); row++) {
            for (int column = 0; column < grid.getNumberOfColumns(); column++) {
                if (grid.getGrid()[row][column] instanceof Zombie) {
                    // Randomly determine whether to move the zombie
                    double moveProbability = Math.random();

                    if (moveProbability > CHANCE_OF_ZOMBIE_NOT_MOVING) { // 75% chance of movement

                        // Move the zombie
                        moveZombie(row, column);
                    }
                }
            }
        }
    }

    /**
     * Checks whether the move of the Zombie is valid or not.
     *
     * @param row    to move to.
     * @param column to move to.
     * @return true if valid cell to move to, false otherwise.
     */
    private boolean isValidZombieMove(int row, int column) {
        // Check if the move is valid, and also prevent zombies from walking through fruits, barbies, walls, and other zombies.
        return isValidCell(row, column) && isValidMove(row, column) &&
                !(grid.getGrid()[row][column] instanceof Fruit);
    }

    /**
     * Moves the zombie.
     *
     * @param zombieRow    to move to.
     * @param zombieColumn to move to.
     */
    private void moveZombie(int zombieRow, int zombieColumn) {
        // Get the direction towards Barbie, smart way of doing so
        int rowDirection = Integer.compare(grid.getBarbieRow(), zombieRow);
        int colDirection = Integer.compare(grid.getBarbieColumn(), zombieColumn);

        // Zombies can move diagonally too (for now)
        int newRow = zombieRow + rowDirection;
        int newColumn = zombieColumn + colDirection;

        // Ensure there's no obstacle and perform the move
        if (isValidZombieMove(newRow, newColumn)) {
            grid.getGrid()[newRow][newColumn] = grid.getGrid()[zombieRow][zombieColumn];
            grid.getGrid()[zombieRow][zombieColumn] = null;
        }
        // If the move is not valid, don't move the zombie.
    }


    /**
     * Moves Barbie to a particular direction.
     *
     * @param direction to move to.
     */
    @Override
    public void moveBarbie(String direction) {
        // Keeping a copy of the current position of Barbie
        int currentRow = grid.getBarbieRow();
        int currentColumn = grid.getBarbieColumn();

        // We'll update Barbie's position based on direction
        switch (direction) {
            case "up":
                if (grid.getBarbieRow() > 0) {
                    grid.setBarbieRow(grid.getBarbieRow() - 1);
                }
                break;
            case "down":
                if (grid.getBarbieRow() < grid.getNumberOfRows() - 1) {
                    grid.setBarbieRow(grid.getBarbieRow() + 1);
                }
                break;
            case "left":
                if (grid.getBarbieColumn() > 0) {
                    grid.setBarbieColumn(grid.getBarbieColumn() - 1);
                }
                break;
            case "right":
                if (grid.getBarbieColumn() < grid.getNumberOfColumns() - 1) {
                    grid.setBarbieColumn(grid.getBarbieColumn() + 1);
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid direction provided by user: " + direction);
        }

        // Check if the new position is valid (that is, no obstacle is present)
        if (isValidBarbieMove()) {


            // Check if fruit exists
            if (grid.getGrid()[grid.getBarbieRow()][grid.getBarbieColumn()] instanceof Fruit) {
                grid.setNumberOfFruits(grid.getNumberOfFruits() - 1);
                Barbie barbie = grid.getBarbie();
                barbie.setHealth(barbie.getHealth() + FRUIT_HEALTH_GAIN);
                if (getFruits() == 0) {
                    swapGameInProgress();
                    gameWon = true;
                    score++;
                    updateHighScore();
                }
            }

            // Place Barbie in the new position
            grid.getGrid()[grid.getBarbieRow()][grid.getBarbieColumn()] = grid.getGrid()[currentRow][currentColumn];

            // Clear old position
            grid.getGrid()[currentRow][currentColumn] = null;

        } else {
            // If the move is not valid, revert Barbie's position to the old one
            grid.setBarbieRow(currentRow);
            grid.setBarbieColumn(currentColumn);
        }
        update(); // Updates state of all other entities
    }

    /**
     * Helper method to ensure that the new position is not invalid.
     *
     * @return true if valid, false otherwise.
     */
    private boolean isValidBarbieMove() {
        return isValidCell(grid.getBarbieRow(), grid.getBarbieColumn()) && isValidMove(grid.getBarbieRow(), grid.getBarbieColumn());
    }

    /**
     * Accessor method for number of fruits.
     *
     * @return number of fruits.
     */
    @Override
    public int getFruits() {
        return grid.getNumberOfFruits();
    }

    /**
     * Return the grid.
     *
     * @return the grid object.
     */
    @Override
    public IGrid getGrid() {
        return grid;
    }

    /**
     * Accessor for gameInProgress variable.
     *
     * @return true if game is still in progress, false otherwise.
     */
    @Override
    public boolean getGameInProgress() {
        return gameInProgress;
    }

    /**
     * Swaps state of gameInProgress.
     */
    @Override
    public void swapGameInProgress() {
        gameInProgress = !gameInProgress;
    }

    /**
     * Retrieves the current status indicating whether the game has been won.
     *
     * @return {@code true} if this particular game has been won; {@code false} otherwise.
     */
    @Override
    public boolean isGameWon() {
        return gameWon;
    }

    /**
     * Swaps state of gameWon.
     */
    @Override
    public void swapGameWon() {
        gameWon = !gameWon;
    }

    /**
     * Resets state of game.
     */
    @Override
    public void resetGame() {
        grid.initializeGrid();
    }

    /**
     * Updates the high score if the current score is higher.
     */
    private void updateHighScore() {
        if (score > highScore) {
            highScore = score;
        }
    }

    /**
     * Retrieves the high score variable.
     *
     * @return The current high score.
     */
    @Override
    public int getHighScore() {
        return highScore;
    }


    /**
     * Accessor for score.
     *
     * @return score.
     */
    @Override
    public int getScore() {
        return score;
    }


}

