package com.faycalkilali.fruitcollectorapp.controller;

import com.faycalkilali.fruitcollectorapp.model.Entity;
import com.faycalkilali.fruitcollectorapp.model.IGrid;

import com.faycalkilali.fruitcollectorapp.view.GridView;
import com.faycalkilali.fruitcollectorapp.view.Viewable;


public class GridController implements IGridController {

    private IGrid grid;
    private final Viewable gridView;

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

    @Override
    public Viewable getView() {
        return gridView;
    }

    @Override
    public void setGrid(IGrid grid) {
        this.grid = grid;
    }


}
