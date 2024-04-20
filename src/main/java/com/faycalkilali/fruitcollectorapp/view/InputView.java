package com.faycalkilali.fruitcollectorapp.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView implements Inputable{
    private String contents = "";
    private final Scanner scanner;


    public InputView(){
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the contents of the view.
     */
    @Override
    public void display() {
        System.out.println(contents);
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

    /**
     * Takes user input as an integer.
     *
     * @return The integer value entered by the client.
     * @throws InputMismatchException If the provided user's input is not a valid integer.
     */
    @Override
    public int inputInt(){
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            // Case where input is not an integer
            throw new InputMismatchException("Input must be an integer");
        }
    }

    /**
     * Takes user input as a String.
     *
     * @return The String value entered by the client.
     * @throws InputMismatchException If the provided user's input is not a valid String.
     */
    @Override
    public String inputString(){
        try {
            return scanner.nextLine();
        } catch (InputMismatchException e) {
            // Case where the input string is not valid
            throw new InputMismatchException("Input must be a string");
        }
    }

}
