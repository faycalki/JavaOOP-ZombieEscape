package com.faycalkilali.fruitcollectorapp.controller;

import com.faycalkilali.fruitcollectorapp.model.IGrid;
import com.faycalkilali.fruitcollectorapp.view.HeadUpDisplayView;
import com.faycalkilali.fruitcollectorapp.view.Viewable;

public class HeadUpDisplayController implements IHeadUpDisplayController {

    private IGrid grid;
    private final Viewable headsUpDisplayView;

    /**
     * Constructor for the class object.
     */
    public HeadUpDisplayController(){
        headsUpDisplayView = new HeadUpDisplayView();
    }

    /**
     * Parses the heads-up display for the View.
     */
    public void parseHeadsUpDisplay(){
        int barbieHealth = grid.getBarbieHealth();
        int fruits = grid.getNumberOfFruits();

        //return "HP: " + barbieHealth + "\n" + "Fruits remaining: " + fruits;
        headsUpDisplayView.inputFromController("\u001B[32mHP: " + barbieHealth + "\nFruits remaining: " + fruits + "\u001B[0m"); // ANSI-version
    }

    /**
     * Retrieves the memory address of the gridView variable and returns it
     * @return the gridView variable memory address
     */
    @Override
    public Viewable getView() {
        return headsUpDisplayView;
    }

    /**
     * Sets the grid.
     * @param grid the grid to set to
     */
    public void setGrid(IGrid grid) {
        this.grid = grid;
    }


}
