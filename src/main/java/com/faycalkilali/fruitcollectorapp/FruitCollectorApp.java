package com.faycalkilali.fruitcollectorapp;
import com.faycalkilali.fruitcollectorapp.controller.IProgramController;
import com.faycalkilali.fruitcollectorapp.controller.ProgramController;

/**
 * Entry-point for the program of Barbie VS Zombies.
 * @author Faycal Kilali
 * @version 1.1
 */
public class FruitCollectorApp {

    public static void main(String[] args) {
        IProgramController programController = new ProgramController();
        programController.startGameLoop();
    }


}
