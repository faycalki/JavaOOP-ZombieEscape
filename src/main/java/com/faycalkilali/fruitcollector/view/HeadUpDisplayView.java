/*
 * © 2024 Faycal Kilali. All rights reserved.
 *
 * This collection of code, including all its contents, is the property of Faycal Kilali.
 *
 * For inquiries or permission requests, please contact Faycal Kilali at root@faycalkilali.com.
 */

package com.faycalkilali.fruitcollector.view;

/**
 * Represents the HUD, responsible for displaying the relevant parts of the Heads-Up Display.
 *
 * <p>
 * This class implements the {@link Viewable} interface, hence it has the same defined behaviour.
 * </p>
 *
 * <p>
 * The class contains a string variable to store the contents of the HUD and methods to display
 * the HUD contents and update them based on input from the controller.
 * </p>
 *
 * @author Faycal Kilali
 * @version 1.1
 */
public class HeadUpDisplayView implements Viewable {
    private String contents = "";


    /**
     * Displays the contents of the HUD as well as the instructions of how to play.
     * <p>
     * This method displays the game HUD and instructions through textual form.
     * </p>
     */
    @Override
    public void display() {
        // Print instructions, HUD, etc
        System.out.println(Instructions());
        System.out.println(contents);
    }

    /**
     * Receives updates from Controller to update the HUD.
     *
     * @param input a string representing the update.
     */
    @Override
    public void inputFromController(String input) {
        contents = input;
    }

    /**
     * Returns the instructions on how to play.
     *
     * @return a String representing the instructions of how to play the game.
     */
    private String Instructions() {
        return "\u001B[36mInstructions:\n" +
                "Use \u001B[33mW\u001B[36m, \u001B[33mA\u001B[36m, \u001B[33mS\u001B[36m, \u001B[33mD\u001B[36m keys to move Barbie.\n" +
                "\u001B[0m";
    }


}
