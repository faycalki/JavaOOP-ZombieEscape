/*
 * © 2024 Faycal Kilali. All rights reserved.
 *
 * This collection of code, including all its contents, is the property of Faycal Kilali.
 *
 * For inquiries or permission requests, please contact Faycal Kilali at root@faycalkilali.com.
 */

package com.faycalkilali.fruitcollector.controller;

import com.faycalkilali.fruitcollector.model.IProgramFlow;
import com.faycalkilali.fruitcollector.model.ProgramFlow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramControllerTest {

    private ProgramController programController;
    private IProgramFlow programFlow;

    @BeforeEach
    void setUp() {
        programFlow = new ProgramFlow();
        programController = new ProgramController();
    }


    @Test
    void testInitialState() {
        boolean initialStatus = false;
        assertEquals(initialStatus, programFlow.getGameInProgress());
    }


}
