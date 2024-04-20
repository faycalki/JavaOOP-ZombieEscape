

package com.faycalkilali.fruitcollectorapp.controller;

import com.faycalkilali.fruitcollectorapp.model.IProgramFlow;
import com.faycalkilali.fruitcollectorapp.model.ProgramFlow;
import com.faycalkilali.fruitcollectorapp.view.IProgramView;
import com.faycalkilali.fruitcollectorapp.view.InputView;
import com.faycalkilali.fruitcollectorapp.view.Inputable;
import com.faycalkilali.fruitcollectorapp.view.ProgramView;

/**
 * Controller for the CompositeView of the program and the program flow in general.
 *
 * @author Faycal Kilali
 * @version 1.1
 * @implSpec Implemented using MVC Architecture
 */

public class ProgramController implements IProgramController {
    private final IProgramFlow programFlow;
    private final IProgramView view;
    private final IGridController gridController;
    private final IHeadUpDisplayController headUpDisplayController;
    private final Inputable input;

    private static final int START_GAME = 1;


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
                if (programFlow.isGameWon()){
                    programFlow.swapGameWon();
                }
                programFlow.swapGameInProgress();
            }
        }

        // Render the Composite View
        requestFullDisplay();

        while (programFlow.getGameInProgress()) {

            // Check if game is over (all fruits consumed)
            if (programFlow.isGameWon()) {
                view.winScreen();
            }

            // Check if game is over (health is less than or equal to 0)
            if (!programFlow.getGameInProgress() && !programFlow.isGameWon()) {
                view.lostScreen();
            }

            // Entities state update
            programFlow.update();

            // Handle user input
            handleInput();

            // Render the Composite View
            requestFullDisplay();
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
                System.out.println("Unexpected user input: " + move + "\n" + "Try again!");
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
