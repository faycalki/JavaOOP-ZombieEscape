/*
 * © 2024 Faycal Kilali. All rights reserved.
 *
 * This collection of code, including all its contents, is the property of Faycal Kilali.
 *
 * For inquiries or permission requests, please contact Faycal Kilali at root@faycalkilali.com.
 */

package com.faycalkilali.fruitcollector.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class GridTest {

    private Grid grid;

    @BeforeEach
    void setUp() {
        grid = new Grid();
    }

    @Test
    void testInitializeGrid() {

        // Lets make sure the grid is initialized and is not null
        assertNotNull(grid.getGrid());

        // Ensure the array is within the expected range
        int numberOfRows = grid.getNumberOfRows();
        int numberOfColumns = grid.getNumberOfColumns();
        assertTrue(numberOfRows >= 6 && numberOfRows <= 15);
        assertTrue(numberOfColumns >= 6 && numberOfColumns <= 15);

        // Lets make sure Barbie is on the grid
        assertNotNull(grid.getBarbie());
        assertEquals(100, grid.getBarbieHealth());

        // Ensure the following are within the range we expect

        int numberOfFruits = grid.getNumberOfFruits();
        assertTrue(numberOfFruits >= 1 && numberOfFruits <= 20);

        int numberOfZombies = grid.getNumberOfZombies();
        assertTrue(numberOfZombies >= 1 && numberOfZombies <= 10);

        int numberOfWalls = grid.getNumberOfWalls();
        assertTrue(numberOfWalls >= 1 && numberOfWalls <= 6);
    }

    @Test
    void testGetGrid() {
        Entity[][] gridArray = grid.getGrid();
        assertNotNull(gridArray);
        assertEquals(grid.getNumberOfRows(), gridArray.length);
        assertEquals(grid.getNumberOfColumns(), gridArray[0].length);
    }

    @Test
    void testGetBarbieColumn() {
        assertTrue(grid.getBarbieColumn() >= 0 && grid.getBarbieColumn() < grid.getNumberOfColumns());
    }

    @Test
    void testSetBarbieColumn() {
        grid.setBarbieColumn(5);
        assertEquals(5, grid.getBarbieColumn());
    }

    @Test
    void testGetBarbieRow() {
        assertTrue(grid.getBarbieRow() >= 0 && grid.getBarbieRow() < grid.getNumberOfRows());
    }

    @Test
    void testSetBarbieRow() {
        grid.setBarbieRow(7);
        assertEquals(7, grid.getBarbieRow());
    }

    @Test
    void testGetNumberOfColumns() {
        assertTrue(grid.getNumberOfColumns() >= 6 && grid.getNumberOfColumns() <= 15);
    }

    @Test
    void testGetNumberOfFruits() {
        assertTrue(grid.getNumberOfFruits() >= 1 && grid.getNumberOfFruits() <= 20);
    }

    @Test
    void testSetNumberOfFruits() {
        grid.setNumberOfFruits(10);
        assertEquals(10, grid.getNumberOfFruits());
    }

    @Test
    void testGetNumberOfRows() {
        assertTrue(grid.getNumberOfRows() >= 6 && grid.getNumberOfRows() <= 15);
    }

    @Test
    void testGetBarbieHealth() {
        assertEquals(100, grid.getBarbieHealth());
    }

    @Test
    void testGetBarbie() {
        assertNotNull(grid.getBarbie());
        assertEquals(100, grid.getBarbie().getHealth());
    }

    @Test
    void testGetNumberOfWalls() {
        int numberOfWalls = grid.getNumberOfWalls();
        assertTrue(numberOfWalls >= 1 && numberOfWalls <= 6);
    }

    @Test
    void testGetNumberOfZombies() {
        int numberOfZombies = grid.getNumberOfZombies();
        assertTrue(numberOfZombies >= 1 && numberOfZombies <= 10);
    }
}
