

/*
 * © 2024 Faycal Kilali. All rights reserved.
 *
 * This collection of code, including all its contents, is the property of Faycal Kilali.
 *
 * For inquiries or permission requests, please contact Faycal Kilali at root@faycalkilali.com.
 */

/*
 * © 2024 Faycal Kilali. All rights reserved.
 *
 * This code is the property of Faycal Kilali.
 *
 * For inquiries or permission requests, please contact Faycal Kilali at root@faycalkilali.com.
 */

package com.faycalkilali.fruitcollector;
import com.faycalkilali.fruitcollector.controller.IProgramController;
import com.faycalkilali.fruitcollector.controller.ProgramController;

/**
 * Entry-point for the program of Barbie VS Zombies.
 * @author Faycal Kilali
 * @version 1.1
 */
public class Main {

    /**
     * Serves as the entry point for the program.
     * @param args the arguments to pass to the program through the terminal.
     */
    public static void main(String[] args) {
        IProgramController programController = new ProgramController();
        programController.startGameLoop();
    }


}
