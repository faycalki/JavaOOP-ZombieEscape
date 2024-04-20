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


class ProgramFlowTest {

    private ProgramFlow programFlow;

    @BeforeEach
    void setUp() {
        programFlow = new ProgramFlow();
    }

    @Test
    void testInitialization() {
        assertNotNull(programFlow.getGrid());
        assertFalse(programFlow.getGameInProgress());
        assertFalse(programFlow.isGameWon());
        assertEquals(0, programFlow.getScore());
        assertEquals(0, programFlow.getHighScore()); // may have to look more into this
    }







    @Test
    void testResetGame() {
        programFlow.moveBarbie("down");
        programFlow.getGrid().getBarbie().setHealth(50);

        // Resetting the game
        programFlow.resetGame();

        assertFalse(programFlow.getGameInProgress());
        assertFalse(programFlow.isGameWon());
    }


    @Test
    void testSwapGameInProgress() {
        // Swap game in progress
        programFlow.swapGameInProgress();

        // Check if game in progress is swapped correctly
        assertTrue(programFlow.getGameInProgress());

        // Swap game in progress again
        programFlow.swapGameInProgress();

        // Check if game in progress is swapped correctly
        assertFalse(programFlow.getGameInProgress());
    }

    @Test
    void testSwapGameWon() {
        // Swap game won
        programFlow.swapGameWon();

        // Check if game won is swapped correctly
        assertTrue(programFlow.isGameWon());

        // Swap game won again
        programFlow.swapGameWon();

        // Check if game won is swapped correctly
        assertFalse(programFlow.isGameWon());
    }


}
