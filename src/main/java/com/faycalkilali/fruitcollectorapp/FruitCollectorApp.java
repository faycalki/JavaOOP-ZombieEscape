

/*
 * © 2024 Faycal Kilali. All rights reserved.
 *
 * This document, including all its contents, is the property of Faycal Kilali. It is protected by copyright law and may not be reproduced, distributed, or transmitted in any form or by any means without the prior written permission of Faycal Kilali.
 *
 * For inquiries or permission requests, please contact Faycal Kilali at contact@faycalkilali.com.
 */

package com.faycalkilali.fruitcollectorapp;
import com.faycalkilali.fruitcollectorapp.controller.IProgramController;
import com.faycalkilali.fruitcollectorapp.controller.ProgramController;

/**
 * Entry-point for the program of Barbie VS Zombies.
 * @author Faycal Kilali
 * @version 1.1
 */
public class FruitCollectorApp {

    /**
     * Serves as the entry point for the program.
     * @param args the arguments to pass to the program through the terminal.
     */
    public static void main(String[] args) {
        IProgramController programController = new ProgramController();
        programController.startGameLoop();
    }


}
