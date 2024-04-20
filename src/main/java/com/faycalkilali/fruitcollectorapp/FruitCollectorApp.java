

/*
 * © 2024 Faycal Kilali. All rights reserved.
 *
 * This code is the property of Faycal Kilali.
 *
 * For inquiries or permission requests, please contact Faycal Kilali at root@faycalkilali.com.
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
