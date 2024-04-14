package com.faycalkilali.fruitcollectorapp.controller;
import java.util.Scanner;
import com.faycalkilali.fruitcollectorapp.model.IModelInformation;
import com.faycalkilali.fruitcollectorapp.model.ModelInformation;
import com.faycalkilali.fruitcollectorapp.view.ProgramView;
import com.faycalkilali.fruitcollectorapp.view.IProgramView;

/**
 * Controller for the CompositeView of the program and the program flow in general.
 * @implSpec Implemented using MVC Architecture
 * @author Faycal Kilali
 * @version 1.1
 */

public class ProgramController implements IProgramController {
    private IModelInformation modelInformation;
    private IProgramView view;
    private Scanner scanner;
    private boolean gameStarted = false;

    private IGridController gridController;
    private IHeadUpDisplayController headUpDisplayController;

    public ProgramController(){
        this.modelInformation = new ModelInformation();
        this.view = new ProgramView();
        this.headUpDisplayController = new HeadUpDisplayController();
        this.gridController = new GridController();
    }

    /**
     * Begins the main game loop.
     * @implSpec Recursively executes to prevent the game from ending (unless a quit command is executed)
     * TODO: force a quit when a quit command is executed
     */
    @Override
    public void startGameLoop() {

        gameStarted = false;
        scanner = new Scanner(System.in);

        while (!gameStarted) {
            view.welcomeMessage();
            int curValue = scanner.nextInt();
            if (curValue == 1){
                gameStarted = true;
            }
        }

        // Render the Composite View
        view.render();

        while (gameStarted) {


            // Check if game is over (all fruits consumed)
            if (getFruits() == 0){
                view.winScreen();
                gameStarted = false;

            }

            // Check if game is over (health is less than or equal to 0)
            if (getHealth() <= 0){
                view.lostScreen();
                gameStarted = false;

            }

            // Other entities movement
            modelInformation.update();

            // Handle user input
            handleInput();

            // Render the Composite View
            view.render();
        }

        // Reset game if over (for now, we'll just reinitialize the model)
        scanner.close();
        resetGame();

        // Recursively call the game loop
        startGameLoop();

    }


    /**
     * Handles the input from the User, passing valid inputs to the corresponding Model class.
     */
    private void handleInput() {
        String move = scanner.next();
        move = move.toLowerCase();

        switch (move){
            case "w":
                // move barbie up
                modelInformation.moveBarbie("up");
                break;
            case "a":
                // move barbie left
                modelInformation.moveBarbie("left");
                break;
            case "s":
                // move barbie down
                modelInformation.moveBarbie("down");
                break;
            case "d":
                // move barbie right
                modelInformation.moveBarbie("right");
                break;
            case "quit":
                gameStarted = false;
                break;
            default:
                System.out.println("Unexpected user input: " + move + "\n" + "Try again!");
                handleInput();
        }
    }


    /**
     * Resets the modelInformation's state.
     */
    private void resetGame() {
        modelInformation.initializeModel();
    }


    /**
     * Requests Barbie's health from the corresponding Model component.
     * @return Barbie's health
     */
    @Override
    public int getHealth(){
        return modelInformation.getBarbie().getHealth();
    }

    /** Requests number of fruits from the modelInformation.
     * @return the number of fruits remaining
     */
    @Override
    public int getFruits(){
        return modelInformation.getFruits();
    }



}
