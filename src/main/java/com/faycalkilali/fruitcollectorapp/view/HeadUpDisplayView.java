package com.faycalkilali.fruitcollectorapp.view;

public class HeadUpDisplayView implements Viewable {
    private String contents = "";


    @Override
    public void display() {
        // Print instructions, HUD, etc
        System.out.println(Instructions());
        System.out.println(contents);
    }

    /**
     * Receives updates from Model through Controller
     * @param input a string representing the update
     */
    @Override
    public void inputFromController(String input) {
        contents = input;
    }

    /**
     * Returns the instructions on how to play.
     * @return a String representing the instructions of how to play the game
     */
    private String Instructions() {
        return "\u001B[36mInstructions:\n" +
                "Use \u001B[33mW\u001B[36m, \u001B[33mA\u001B[36m, \u001B[33mS\u001B[36m, \u001B[33mD\u001B[36m keys to move Barbie.\n" +
                "\u001B[0m";
    }



}
