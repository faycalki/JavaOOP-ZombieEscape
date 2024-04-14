package com.faycalkilali.fruitcollectorapp.controller;

public class GridController implements IGridController {

    private IGrid grid;
    private Viewable gridView;

    public GridController(){
        grid = new Grid();
        gridView = new GridView(0);
    }


    /**
     * Requests textual representation of the grid from the modelInformation.
     * @return textual representation of the grid
     */
    @Override
    public String getGrid(){
        return grid.toString();
    }

    public Viewable getGridView() {
        return GridView;
    }

}
