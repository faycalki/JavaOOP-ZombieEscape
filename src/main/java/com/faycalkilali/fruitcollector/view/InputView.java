/*
 * © 2024 Faycal Kilali. All rights reserved.
 *
 * This collection of code, including all its contents, is the property of Faycal Kilali.
 *
 * For inquiries or permission requests, please contact Faycal Kilali at root@faycalkilali.com.
 */

package com.faycalkilali.fruitcollector.view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents an input view for receiving user input in the game.
 * <p>
 * This class implements the {@link Inputable}, hence it contains the exact behaviour of the interface.
 * </p>
 * <p>
 * This class implements the {@link Viewable} interface, therefore that exact behaviour is also part of this class.
 * </p>
 * <p>
 * Any object of this class contains a {@code Scanner} object to facilitate input operations from stdio.
 * </p>
 * <p>
 *
 * @author Faycal Kilali
 * @version 1.0
 * @implNote : This class is useful for providing decoupling of user input from other views.
 * </p>
 */
public class InputView implements Inputable {
    private final Scanner scanner;
    private String contents = "";

    /**
     * Creates a {@code InputView} object with a {@code Scanner} object that uses the stdio stream.
     */
    public InputView() {
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
    public int inputInt() {
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
    public String inputString() {
        try {
            return scanner.nextLine();
        } catch (InputMismatchException e) {
            // Case where the input string is not valid
            throw new InputMismatchException("Input must be a string");
        }
    }

}
