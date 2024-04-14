package com.faycalkilali.fruitcollectorapp.view;

public class HeadUpDisplayView implements Viewable {
    private String contents = "";


    @Override
    public void render() {
        // Print instructions, HUD, etc
        System.out.println(Instructions());
        System.out.println(headUpDisplay());
    }

    @Override
    public void inputFromController(String input) {

    }

    /**
     * HUD for the game
     * @return HUD as a String
     */
    private String headUpDisplay(){
        int barbieHealth = controller.getHealth();
        int fruits = controller.getFruits();
        //return "HP: " + barbieHealth + "\n" + "Fruits remaining: " + fruits;
        return "\u001B[32mHP: " + barbieHealth + "\nFruits remaining: " + fruits + "\u001B[0m"; // ANSI-version

    }

    /**
     * Instructions on how to play
     * @return the instructions on how to play as a String
     */
    private String Instructions() {
        return "\u001B[36mInstructions:\n" +
                "Use \u001B[33mW\u001B[36m, \u001B[33mA\u001B[36m, \u001B[33mS\u001B[36m, \u001B[33mD\u001B[36m keys to move Barbie.\n" +
                "\u001B[0m";
    }



}
