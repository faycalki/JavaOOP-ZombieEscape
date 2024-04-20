package com.faycalkilali.fruitcollectorapp.model;

import java.util.Random;

public class Grid implements IGrid{
    private Entity[][] grid;

    private int numberOfFruits;

    private int numberOfRows;

    private int numberOfColumns;

    private int numberOfZombies;
    private int numberOfWalls;
    private final Random rand = new Random();

    private int barbieRow;
    private int barbieColumn;

    private final Barbie barbie;

    public Grid(){
        barbie = new Barbie();
        initializeGrid();
    }

    /**
     * Constructs the grid and places the appropriate objects within it.
     * @implNote The grid is initialized here in order to ensure replayability with varying degrees
     * of rows, columns, and other objects on the grid, as well as starting positions.
     */
    @SuppressWarnings("SpellCheckingInspection")
    @Override
    public void initializeGrid(){

        // Initialize size of grid
        numberOfRows = rand.nextInt(6, 15);
        numberOfColumns = rand.nextInt(6, 15);
        grid = new Entity[numberOfRows][numberOfColumns];

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
                        grid[row][column] = barbie;
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
                            grid[row][column] = barbie;
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

        // The number of those objects was actually just an upper bound, now it is set to the exact amount.
        numberOfZombies = countZombies;
        numberOfWalls = countWalls;
        numberOfFruits = countFruits;

        // Extra-check Barbie is placed
        // TODO: for some reason this is the case sometimes

        if (grid[barbieRow][barbieColumn] == null) {
            grid[barbieRow][barbieColumn] = barbie;
        }
    }

    /**
     * Returns a pointer to the underlying data structure
     * @return pointer to underlying data structure
     */
    @Override
    public Entity[][] getGrid() {
        return grid;
    }

    @Override
    public int getBarbieColumn() {
        return barbieColumn;
    }

    @Override
    public int getBarbieRow() {
        return barbieRow;
    }

    @Override
    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    @Override
    public int getNumberOfFruits() {
        return numberOfFruits;
    }

    @Override
    public int getNumberOfRows() {
        return numberOfRows;
    }

    @Override
    public int getBarbieHealth() {
        return barbie.getHealth();
    }

    @Override
    public Barbie getBarbie() {
        return barbie;
    }

    @Override
    public void setBarbieColumn(int barbieColumn) {
        this.barbieColumn = barbieColumn;
    }

    @Override
    public void setBarbieRow(int barbieRow) {
        this.barbieRow = barbieRow;
    }

    @Override
    public void setNumberOfFruits(int numberOfFruits) {
        this.numberOfFruits = numberOfFruits;
    }
}
