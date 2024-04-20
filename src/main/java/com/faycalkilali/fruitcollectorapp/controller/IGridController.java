package com.faycalkilali.fruitcollectorapp.controller;

import com.faycalkilali.fruitcollectorapp.model.IGrid;
import com.faycalkilali.fruitcollectorapp.view.Viewable;

public interface IGridController {
    void parseGrid();

    Viewable getView();

    void setGrid(IGrid grid);
}
