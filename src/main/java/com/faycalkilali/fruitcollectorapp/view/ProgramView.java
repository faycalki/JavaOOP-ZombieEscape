package com.faycalkilali.fruitcollectorapp.view;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Program View for the overall composite view of the program, responsible for having the appropriate form of displaying the entire program.
 * <p>
 * This class implements the {@link Viewable}, hence it contains the exact behaviour of the interface.
 * </p>
 * <p>
 * Any object of this class contains a {@code Scanner} object to facilitate input operations from stdio.
 * </p>
 * <p>
 * @implNote: This class is useful for providing decoupling of user input from other views.
 * </p>
 *
 * @author Faycal Kilali
 * @version 1.0
 */
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
        System.out.println("Welcome to the Main Menu! Made by Faycal Kilali." + "\n" + "Pick any of the options below." + "\n" + "1. Start game");
    }

    /**
     * The victory screen, typically invoked when the game is won.
     */
    @Override
    public void winScreen() {
        System.out.println("\u001B[32m" + contents +  "Congratulations! You've consumed all of the fruits, winning this level." + "\u001B[0m");
    }

    /**
     * The loss screen, typically invoked when the game is lost.
     */
    @Override
    public void lostScreen() {
        System.out.println("\u001B[31m" + contents + "You've lost all the health points allocated, therefore the game is over!" + "\u001B[0m");
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
