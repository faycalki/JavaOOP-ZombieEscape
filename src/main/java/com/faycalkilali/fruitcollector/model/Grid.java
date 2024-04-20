/*
 * © 2024 Faycal Kilali. All rights reserved.
 *
 * This collection of code, including all its contents, is the property of Faycal Kilali.
 *
 * For inquiries or permission requests, please contact Faycal Kilali at root@faycalkilali.com.
 */

package com.faycalkilali.fruitcollector.model;

import java.util.Random;

/**
 * Represents the grid of the game, containing all its entities.
 *
 * <p>The grid is initialized with various dimensions and populated with entities.</p>
 *
 * <p>This class implements the {@link IGrid} interface, providing the expected behaviors.</p>
 *
 * <p>It also uses the {@link Random} class for generating random numbers to place entities within the grid.</p>
 *
 * <p>This class has defined behaviour to initialize the grid, retrieve information about it and its entities,
 * and modify the grid's state as required.</p>
 *
 * @author Faycal Kilali
 * @version 1.2
 * @implNote This class may have too many responsibilities.
 * However, they all adhere to responsibilities involving the grid. Hence, further analysis may be of use to determine if it has too many responsibilities.
 */
public class Grid implements IGrid {
    private final Random rand = new Random();
    private final Barbie barbie;
    private Entity[][] grid;
    private int numberOfFruits;
    private int numberOfRows;
    private int numberOfColumns;
    private int numberOfZombies;
    private int numberOfWalls;
    private int barbieRow;
    private int barbieColumn;

    public Grid() {
        barbie = new Barbie();
        initializeGrid();
    }

    /**
     * Constructs the grid and places the appropriate objects within it.
     *
     * @implNote The grid is initialized here in order to ensure replayability with varying degrees
     * of rows, columns, and other objects on the grid, as well as starting positions.
     */
    @SuppressWarnings("SpellCheckingInspection")
    @Override
    public void initializeGrid() {
        barbieColumn = 0;
        barbieRow = 0;

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
        double zombieProbability = (1.0 * 10) / (numberOfColumns * numberOfRows);

        // Initialize number of walls
        numberOfWalls = rand.nextInt(1, 6);
        int countWalls = 0;
        double wallProbability = (0.4 * 10) / (numberOfColumns * numberOfRows);

        // Initializing barbie probability
        double barbieProbability = (0.1 * 10) / (numberOfColumns * numberOfRows);

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


        // If barbie, a wall, a zombie, or a fruit have not been placed...
        if (!barbiePlaced || !wallPlaced || !zombiePlaced || !fruitPlaced) {
            for (int row = 0; row < numberOfRows; row++) {
                for (int column = 0; column < numberOfColumns; column++) {
                    if (grid[row][column] == null) {

                        if (!barbiePlaced) {
                            grid[row][column] = barbie;
                            barbieRow = row;
                            barbieColumn = column;
                            barbiePlaced = true;
                        } else if (!wallPlaced) {
                            grid[row][column] = new Wall();
                            wallPlaced = true;
                            countWalls++;
                        } else if (!zombiePlaced) {
                            zombiePlaced = true;
                            grid[row][column] = new Zombie();
                            countZombies++;
                        } else if (!fruitPlaced) {
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

        if (grid[barbieRow][barbieColumn] == null) {
            grid[barbieRow][barbieColumn] = barbie;
        }
    }

    /**
     * Returns a pointer to the underlying data structure.
     *
     * @return pointer to underlying data structure.
     */
    @Override
    public Entity[][] getGrid() {
        return grid;
    }

    /**
     * Accessor for retrieving the column index of Barbie's current position on the grid.
     *
     * @return The column index of Barbie's position.
     */
    @Override
    public int getBarbieColumn() {
        return barbieColumn;
    }

    /**
     * Mutator for setting the column index of Barbie's position on the grid.
     *
     * @param barbieColumn The column index to set.
     */
    @Override
    public void setBarbieColumn(int barbieColumn) {
        this.barbieColumn = barbieColumn;
    }

    /**
     * Accessor for retrieving the row index of Barbie's current position on the grid.
     *
     * @return The row index of Barbie's position.
     */
    @Override
    public int getBarbieRow() {
        return barbieRow;
    }

    /**
     * Mutator for setting the row index of Barbie's position on the grid.
     *
     * @param barbieRow The row index to set.
     */
    @Override
    public void setBarbieRow(int barbieRow) {
        this.barbieRow = barbieRow;
    }

    /**
     * Accessor for retrieving the total number of columns in the grid.
     *
     * @return The total number of columns in the grid.
     */
    @Override
    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    /**
     * Accessor for retrieving the total number of fruits present on the grid.
     *
     * @return The total number of fruits present on the grid.
     */
    @Override
    public int getNumberOfFruits() {
        return numberOfFruits;
    }

    /**
     * Mutator for setting the total number of fruits on the grid.
     *
     * @param numberOfFruits The total number of fruits to set.
     */
    @Override
    public void setNumberOfFruits(int numberOfFruits) {
        this.numberOfFruits = numberOfFruits;
    }

    /**
     * Accessor for retrieving the total number of rows in the grid.
     *
     * @return The total number of rows in the grid.
     */
    @Override
    public int getNumberOfRows() {
        return numberOfRows;
    }

    /**
     * Accessor for retrieving the current health of Barbie.
     *
     * @return The current health of Barbie.
     */
    @Override
    public int getBarbieHealth() {
        return barbie.getHealth();
    }

    /**
     * Accessor for retrieving the Barbie object.
     *
     * @return The Barbie object.
     */
    @Override
    public Barbie getBarbie() {
        return barbie;
    }

    /**
     * Accessor for the number of walls on the grid.
     * @return number of walls.
     */
    @Override
    public int getNumberOfWalls() {
        return numberOfWalls;
    }

    /**
     * Accessor for the number of zombies on the grid.
     * @return number of zombies on the grid.
     */
    @Override
    public int getNumberOfZombies() {
        return numberOfZombies;
    }


}
