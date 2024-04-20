package com.faycalkilali.fruitcollectorapp.view;

import java.util.ArrayList;
import java.util.List;

public class ProgramView implements IProgramView{
    private String contents;
    private final List<Viewable> list;

    /**
     * Constructor for a ProgramView object. Initializes the initial state of the object.
     */
    public ProgramView(){
        contents = "";
        list = new ArrayList<>();
    }

    /**
     * The welcoming message for the game, typically invoked at main menu.
     */
    @Override
    public void welcomeMessage(){
        System.out.println("This game is made in an effort to satisfy certain OOP principles, made by Faycal Kilali." + "\n" + "1. Start game");
    }

    /**
     * The victory screen, typically invoked when the game is won.
     */
    @Override
    public void winScreen() {
        System.out.println("\u001B[32mCongratulations! You've consumed all of the fruits, winning the game.\u001B[0m");
    }

    /**
     * The loss screen, typically invoked when the game is lost.
     */
    @Override
    public void lostScreen() {
        System.out.println("\u001B[31mYou've lost all the health points allocated, therefore the game is over!\u001B[0m");
    }

    /**
     * Adds a Viewable object to the list of Viewable objects.
     * @param view the Viewable object to add to the lit.
     */
    @Override
    public void addView(Viewable view) {
        list.add(view);
    }

    /**
     * Displays the contents of the view.
     */
    @Override
    public void display() {
        System.out.println(contents);
        for (Viewable view: list){
            view.display();
        }
    }

    /**
     * Updates the contents of this input view based on input received from the respective controller.
     *
     * @param input The input received from the respective controller.
     */
    @Override
    public void inputFromController(String input) {
        contents = input;
    }


}
