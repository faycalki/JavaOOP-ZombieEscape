package com.faycalkilali.fruitcollectorapp.controller;

import com.faycalkilali.fruitcollectorapp.model.IGrid;
import com.faycalkilali.fruitcollectorapp.view.Viewable;

public interface IHeadUpDisplayController {

    void parseHeadsUpDisplay();

    Viewable getView();

    void setGrid(IGrid grid);

}
