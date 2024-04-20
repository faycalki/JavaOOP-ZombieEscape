package com.faycalkilali.fruitcollectorapp.view;
/**
 * Represents the grid view in the game, responsible for displaying the game map.
 *
 * <p>
 * This class implements the {@link Viewable} interface, hence it has the same defined behaviour.
 * </p>
 *
 * <p>
 * The class contains a string variable to store the contents of the grid and methods to display
 * the grid contents and update them based on input from the controller.
 * </p>
 *
 * @author Faycal Kilali
 * @version 1.1
 */
public class GridView implements Viewable{
    private String contents = "";


    /**
     * Displays the contents of the grid.
     * <p>
     * This method displays the game map through textual form.
     * </p>
     */
    @Override
    public void display() {
        // Render the game map
        System.out.println(contents);
    }

    /**
     * Receives input from the controller to update the contents of the grid.
     *
     * @param input the input string containing the updated contents of the grid
     */
    @Override
    public void inputFromController(String input) {
        contents = input;
    }
}
