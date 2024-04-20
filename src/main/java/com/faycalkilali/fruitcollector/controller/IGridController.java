/*
 * © 2024 Faycal Kilali. All rights reserved.
 *
 * This collection of code, including all its contents, is the property of Faycal Kilali.
 *
 * For inquiries or permission requests, please contact Faycal Kilali at root@faycalkilali.com.
 */

package com.faycalkilali.fruitcollector.controller;

import com.faycalkilali.fruitcollector.model.IGrid;
import com.faycalkilali.fruitcollector.view.Viewable;

public interface IGridController {
    void parseGrid();

    Viewable getView();

    void setGrid(IGrid grid);
}
