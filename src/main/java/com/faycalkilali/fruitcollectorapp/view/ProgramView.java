package com.faycalkilali.fruitcollectorapp.view;

public class ProgramView implements IProgramView{
    private String contents = "";

    /**
     * The Welcome message for the game, invoked at main menu.
     */
    @Override
    public void welcomeMessage(){
        System.out.println("Welcome to Barbie VS Zombies! An exciting grid-based game satisfying certain OOP principles, made by Faycal Kilali." + "\n" + "1. Start game");
    }

    /**
     * The victory screen, invoked when won
     */
    @Override
    public void winScreen() {
        System.out.println("\u001B[32mCongratulations! You've consumed all of the fruits, winning the game.\u001B[0m");
    }


    /**
     * The loss screen, invoked when lost
     */
    @Override
    public void lostScreen() {
        System.out.println("\u001B[31mYou've lost all the health points allocated, therefore the game is over!\u001B[0m");
    }

    @Override
    public void addView(Viewable view) {

    }

    @Override
    public void render() {

    }

    @Override
    public void inputFromController(String input) {

    }


}
