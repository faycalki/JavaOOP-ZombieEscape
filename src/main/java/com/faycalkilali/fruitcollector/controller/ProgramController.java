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
import com.faycalkilali.fruitcollector.view.IProgramView;
import com.faycalkilali.fruitcollector.view.InputView;
import com.faycalkilali.fruitcollector.view.Inputable;
import com.faycalkilali.fruitcollector.view.ProgramView;

/**
 * Controller for the CompositeView of the program and the program flow in general.
 *
 * @author Faycal Kilali
 * @version 1.1
 * @implNote Implemented using MVC Architecture.
 */

public class ProgramController implements IProgramController {
    private static final int START_GAME = 1;
    private final IProgramFlow programFlow;
    private final IProgramView view;
    private final IGridController gridController;
    private final IHeadUpDisplayController headUpDisplayController;
    private final Inputable input;


    /**
     * Constructor for the ProgramController object.
     * Sets up the connections for the controllers with their model components and constructs the first model object.
     */
    public ProgramController() {
        this.programFlow = new ProgramFlow();
        this.view = new ProgramView();
        this.headUpDisplayController = new HeadUpDisplayController();
        this.gridController = new GridController();
        this.input = new InputView();

        // Composite the views
        this.view.addView(headUpDisplayController.getView());
        this.view.addView(gridController.getView());

        // Set up the model components for the views
        headUpDisplayController.setGrid(programFlow.getGrid());
        gridController.setGrid(programFlow.getGrid());

    }

    /**
     * Begins the controller loop for the game.
     *
     * @implNote Although the game is fully playable by feeding the model input,
     * this method will serve as an interface for acquiring user input for this particular implementation of the Controller-View.
     */
    @Override
    public void startGameLoop() {


        while (!programFlow.getGameInProgress()) {
            view.welcomeMessage();
            int curValue = input.inputInt();
            if (curValue == START_GAME) {
                if (programFlow.isGameWon()) {
                    programFlow.swapGameWon();
                }
                programFlow.swapGameInProgress();
            }
        }

        // Render the Composite View
        requestFullDisplay();

        while (programFlow.getGameInProgress()) {

            // Handle user input
            handleInput();

            // Render the Composite View
            requestFullDisplay();


            // Check if game is over (all fruits consumed)
            if (programFlow.isGameWon()) {
                int score = programFlow.getScore();
                int highScore = programFlow.getHighScore();
                String formattedScores = String.format("Score: %d\nHigh Score: %d\n", score, highScore);
                view.inputFromController(formattedScores);
                view.winScreen();
            }

            // Check if game is over (health is less than or equal to 0)
            if (!programFlow.getGameInProgress() && !programFlow.isGameWon()) {
                int score = programFlow.getScore();
                int highScore = programFlow.getHighScore();
                String formattedScores = String.format("Score: %d\nHigh Score: %d\n", score, highScore);
                view.inputFromController(formattedScores);
                view.lostScreen();
            }
        }

        // Reset game if over (for now, we'll just reinitialize the model)
        resetGame();

        // Recursively call the game loop
        startGameLoop();

    }

    /**
     * Handles the input from the User, passing valid inputs to the corresponding Model class.
     */
    private void handleInput() {
        String move = input.inputString();
        move = move.toLowerCase();

        switch (move) {
            case "w":
                // move barbie up
                programFlow.moveBarbie("up");
                break;
            case "a":
                // move barbie left
                programFlow.moveBarbie("left");
                break;
            case "s":
                // move barbie down
                programFlow.moveBarbie("down");
                break;
            case "d":
                // move barbie right
                programFlow.moveBarbie("right");
                break;
            case "quit":
                programFlow.swapGameInProgress();
                break;
            default:
                handleInput();
        }
    }

    /**
     * Displays the composite view.
     */
    private void requestFullDisplay() {
        gridController.parseGrid();
        headUpDisplayController.parseHeadsUpDisplay();
        view.display();
    }

    /**
     * Resets the programFlow's state.
     */
    private void resetGame() {
        programFlow.resetGame();
    }


}
