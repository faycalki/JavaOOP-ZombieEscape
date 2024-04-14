package com.faycalkilali.fruitcollectorapp.model;

import java.util.Random;

/**
 * The first model object to be created in the MVC-Architecture. Entry-point for the creation of the rest of the Model.
 * Performs logical manipulation or requisition of the data when commanded to by the Controller.
 * @author Faycal Kilali
 * @version 1.1
 */


public class ModelInformation implements IModelInformation {
    private Object[][] grid;
    private int numberOfFruits;

    private int numberOfRows;

    private int numberOfColumns;

    private int numberOfZombies;
    private int numberOfWalls;
    private int barbieRow;
    private int barbieColumn;
    private Random rand = new Random();



    public ModelInformation(){
        initializeModel();
    }

    /**
     * Initializes initial Model state
     */
    public void initializeModel(){

        // Initialize size of grid
        numberOfRows = rand.nextInt(6, 15);
        numberOfColumns = rand.nextInt(6, 15);
        grid = new Object[numberOfRows][numberOfColumns];

        // Initialize number of fruits
        numberOfFruits = rand.nextInt(1, 20);
        int countFruits = 0;
        double fruitProbability = (0.5 * 10) / (numberOfColumns * numberOfRows);

        // Initialize number of zombies
        numberOfZombies = rand.nextInt(1, 10);
        int countZombies = 0;
        double zombieProbability = (1.0 * 10)/ (numberOfColumns * numberOfRows);

        // Initialize number of walls
        numberOfWalls = rand.nextInt(1, 15);
        int countWalls = 0;
        double wallProbability = (0.25 * 10)/ (numberOfColumns * numberOfRows);

        double barbieProbability = (0.1 * 10)/ (numberOfColumns * numberOfRows);

        // Flag to check if object has been placed
        boolean barbiePlaced = false;
        boolean zombiePlaced = false;
        boolean wallPlaced = false;
        boolean fruitPlaced = false;

        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                if (grid[row][column] == null) {
                    double randomValue = rand.nextDouble();


                    // Place Barbie
                    if (!barbiePlaced && randomValue <= barbieProbability && (grid[row][column] == null)) {
                        grid[row][column] = new Barbie();
                        barbiePlaced = true;
                        barbieRow = row;
                        barbieColumn = column;
                    }

                    // Place fruits
                    else if (countFruits < numberOfFruits && randomValue <= fruitProbability) {
                        grid[row][column] = new Fruit();
                        countFruits++;
                        fruitPlaced = true;
                    }
                    // Place zombies
                    else if ((countZombies < numberOfZombies && randomValue <= zombieProbability)) {
                        grid[row][column] = new Zombie();
                        countZombies++;
                        zombiePlaced = true;
                    }
                    // Place walls
                    else if (countWalls < numberOfWalls && randomValue <= wallProbability) {
                        grid[row][column] = new Wall();
                        countWalls++;
                        wallPlaced = true;
                    }
                }
            }

        }



        // If Barbie has not been placed, place her in the first available empty cell
        if (!barbiePlaced && !wallPlaced && !zombiePlaced && !fruitPlaced) {
            for (int row = 0; row < numberOfRows; row++) {
                for (int column = 0; column < numberOfColumns; column++) {
                    if (grid[row][column] == null) {

                        if (!barbiePlaced) {
                            grid[row][column] = new Barbie();
                            barbieRow = row;
                            barbieColumn = column;
                            barbiePlaced = true;
                        }
                        else if (!wallPlaced){
                            grid[row][column] = new Wall();
                            wallPlaced = true;
                            countWalls++;
                        }
                        else if(!zombiePlaced){
                            zombiePlaced = true;
                            grid[row][column] =  new Zombie();
                            countZombies++;
                        }
                        else if (!fruitPlaced){
                            fruitPlaced = true;
                            grid[row][column] = new Fruit();
                            countFruits++;
                        }
                    }
                }
            }
        }

        // The number of those objects was actually just an upper bound, now its set to the exact amount.
        numberOfZombies = countZombies;
        numberOfWalls = countWalls;
        numberOfFruits = countFruits;

        // Extra-check Barbie is placed
        // TODO: for some reason this is the case sometimes

        if (grid[barbieRow][barbieColumn] == null) {
            grid[barbieRow][barbieColumn] = new Barbie();
        }
    }

    /**
     * Updates state of Zombies
     */
    public void update() {
        // Is Barbie next to some zombie? If she is, lose 5 health per adjacent zombie tile
        checkBarbieAdjacentToZombie();

        // Move zombies randomly
        moveZombiesRandomly();
    }

    /**
     * Checks if Barbie is Adjacent to a Zombie
     */
    private void checkBarbieAdjacentToZombie() {
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                // Check if Barbie is adjacent to the zombie
                if (grid[row][column] instanceof Zombie && isBarbieAdjacent(row, column)) {
                    Barbie barbie = (Barbie) grid[barbieRow][barbieColumn];
                    barbie.setHealth(barbie.getHealth() - 5);
                }
            }
        }
    }


    /**
     * Checks if Barbie is adjacent to adjacent to a zombie helper method
     * @param zombieRow row of zombie
     * @param zombieColumn column of zombie
     * @return true if she is adjacent to a zombie, false otherwise
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
                    if (grid[adjacentRow][adjacentCol] instanceof Barbie) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks if a cell is valid for movement towards
     * @param row of cell
     * @param column of cell
     * @return true if it is valid to move to cell, false otherwise
     */
    private boolean isValidCell(int row, int column) {
        if (row < 0 || row >= numberOfRows || column < 0 || column >= numberOfColumns) {
            return false; // Outside the grid boundaries
        }

        // Don't overwrite any of those instances (can't walk into them)
        return (!(grid[row][column] instanceof Wall));

    }

    /**
     * Enforces a random chance of a zombie moving
     */
    private void moveZombiesRandomly() {
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                if (grid[row][column] instanceof Zombie) {
                    // Randomly determine whether to move the zombie
                    double moveProbability = Math.random();

                    // Check if it's valid to move the zombie (not a wall or outside the grid)
                    if (moveProbability > 1/4 && isValidZombieMove(row, column)) { // 75% chance of movement

                        // Move the zombie
                        moveZombie(row, column);
                    }
                }
            }
        }
    }

    /**
     * Checks whether the move of the Zombie is valid or not
     * @param row to move to
     * @param column to move to
     * @return true if valid cell to move to, false otherwise
     */
    private boolean isValidZombieMove(int row, int column) {
        // Check if the move is valid, and also prevent zombies from walking through fruits
        return (isValidCell(row, column)) && !(grid[row][column] instanceof Fruit) && !(grid[row][column] instanceof Barbie);
    }

    /**
     * Moves the zombie
     * @param zombieRow to move to
     * @param zombieColumn to move to
     */
    private void moveZombie(int zombieRow, int zombieColumn) {
        // Get the direction towards Barbie, smart way of doing so
        int rowDirection = Integer.compare(barbieRow, zombieRow);
        int colDirection = Integer.compare(barbieColumn, zombieColumn);

        // Zombies can move diagonally too (for now)
        int newRow = zombieRow + rowDirection;
        int newColumn = zombieColumn + colDirection;

        // Ensure there's no obstacle and perform the move
        if (isValidZombieMove(newRow, newColumn)) {
            if (grid[newRow][newColumn] instanceof Zombie){
                // Don't move the zombie
            }

            else {
                grid[newRow][newColumn] = grid[zombieRow][zombieColumn];
                grid[zombieRow][zombieColumn] = null;
            }
        }
        // If the move is not valid, don't move the zombie.
    }


    /**
     * Moves Barbie to a particular direction
     * @param direction to move to
     */
    public void moveBarbie(String direction) {
        // Keeping a copy of the current position of Barbie
        int currentRow = barbieRow;
        int currentColumn = barbieColumn;

        // We'll update Barbie's position based on direction
        switch (direction) {
            case "up":
                if (barbieRow > 0) {
                    barbieRow--;
                }
                break;
            case "down":
                if (barbieRow < numberOfRows - 1) {
                    barbieRow++;
                }
                break;
            case "left":
                if (barbieColumn > 0) {
                    barbieColumn--;
                }
                break;
            case "right":
                if (barbieColumn < numberOfColumns - 1) {
                    barbieColumn++;
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid direction provided by user: " + direction);
        }

        // Check if the new position is valid (that is, no obstacle is present)
        if (isValidBarbieMove()) {


            // Check if fruit exists
            if (grid[barbieRow][barbieColumn] instanceof Fruit){
                numberOfFruits--;
                Barbie barbie = (Barbie) grid[currentRow][currentColumn];
                barbie.setHealth(barbie.getHealth() + 10);
            }

            // Place Barbie in the new position
            grid[barbieRow][barbieColumn] = grid[currentRow][currentColumn];

            // Clear old position
            grid[currentRow][currentColumn] = null;

        }

        else {
            // If the move is not valid, revert Barbie's position to the old one
            barbieRow = currentRow;
            barbieColumn = currentColumn;
        }
    }

    /**
     * Helper method to ensure that the new position is not invalid
     * @return true if valid, false otherwise
     */
    private boolean isValidBarbieMove() {
        return isValidCell(barbieRow, barbieColumn) && !(grid[barbieRow][barbieColumn] instanceof Zombie);

    }




    /**
     * Accessor method for Barbie
     * @return barbie
     */
    public Barbie getBarbie(){
        return (Barbie) grid[barbieRow][barbieColumn];
    }

    /**
     * Accessor method for number of fruits
     * @return number of fruits
     */
    public int getFruits(){
        return numberOfFruits;
    }


}

