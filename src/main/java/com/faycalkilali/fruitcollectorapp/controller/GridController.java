package com.faycalkilali.fruitcollectorapp.controller;

import com.faycalkilali.fruitcollectorapp.model.Entity;
import com.faycalkilali.fruitcollectorapp.model.IGrid;
import com.faycalkilali.fruitcollectorapp.view.GridView;
import com.faycalkilali.fruitcollectorapp.view.Viewable;

/**
 * Controller for managing the grid view component in the MVC architecture.
 *
 * @author Faycal Kilali
 * @version 1.1
 */
public class GridController implements IGridController {

    private IGrid grid;
    private final Viewable gridView;

    /**
     * Constructs a new GridController object.
     * <p>
     * This constructor initializes a new instance of the GridController class.
     * The constructor creates a new instance of the GridView class to manage the graphical representation of the grid through the MVC architecture.
     * </p>
     */
    public GridController(){
        gridView = new GridView();
    }

    /**
     * Prepares the Grid and its contents for the View.
     */
    @Override
    public void parseGrid(){
        StringBuilder result = new StringBuilder();

        for (int row = 0; row < grid.getNumberOfRows(); row++) {
            for (int column = 0; column < grid.getNumberOfColumns(); column++) {
                Entity cell = grid.getGrid()[row][column];
                if (cell == null) {
                    result.append("\u001B[37mX\u001B[0m\t");
                } else {
                    result.append(cell.toString()).append("\t");
                }
            }
            result.append("\n");
        }

        gridView.inputFromController(result.toString());
    }

    /**
     * Accessor for the View component.
     * @return the Viewable object.
     */
    @Override
    public Viewable getView() {
        return gridView;
    }

    /**
     * Mutator for the grid.
     * @param grid to mutate to.
     */
    @Override
    public void setGrid(IGrid grid) {
        this.grid = grid;
    }


}
