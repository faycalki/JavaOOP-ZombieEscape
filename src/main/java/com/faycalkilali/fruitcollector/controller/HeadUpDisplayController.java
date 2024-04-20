/*
 * © 2024 Faycal Kilali. All rights reserved.
 *
 * This collection of code, including all its contents, is the property of Faycal Kilali.
 *
 * For inquiries or permission requests, please contact Faycal Kilali at root@faycalkilali.com.
 */

package com.faycalkilali.fruitcollector.controller;

import com.faycalkilali.fruitcollector.model.IGrid;
import com.faycalkilali.fruitcollector.view.HeadUpDisplayView;
import com.faycalkilali.fruitcollector.view.Viewable;

/**
 * Controller for managing the grid HUD component in the MVC architecture.
 *
 * @author Faycal Kilali
 * @version 1.1
 */
public class HeadUpDisplayController implements IHeadUpDisplayController {

    private final Viewable headsUpDisplayView;
    private IGrid grid;

    /**
     * Constructor for the class object.
     */
    public HeadUpDisplayController() {
        headsUpDisplayView = new HeadUpDisplayView();
    }

    /**
     * Parses the heads-up display for the View.
     */
    public void parseHeadsUpDisplay() {
        int barbieHealth = grid.getBarbieHealth();
        int fruits = grid.getNumberOfFruits();

        headsUpDisplayView.inputFromController("\u001B[32mHP: " + barbieHealth + "\nFruits remaining: " + fruits + "\u001B[0m"); // ANSI-version
    }

    /**
     * Retrieves the memory address of the gridView variable and returns it
     *
     * @return the gridView variable memory address
     */
    @Override
    public Viewable getView() {
        return headsUpDisplayView;
    }

    /**
     * Sets the grid.
     *
     * @param grid the grid to set to.
     */
    public void setGrid(IGrid grid) {
        this.grid = grid;
    }


}
