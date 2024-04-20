/*
 * © 2024 Faycal Kilali. All rights reserved.
 *
 * This collection of code, including all its contents, is the property of Faycal Kilali.
 *
 * For inquiries or permission requests, please contact Faycal Kilali at root@faycalkilali.com.
 */

package com.faycalkilali.fruitcollector.model;

public interface IGrid {


    void initializeGrid();

    Entity[][] getGrid();

    int getBarbieColumn();

    void setBarbieColumn(int barbieColumn);

    int getBarbieRow();

    void setBarbieRow(int barbieRow);

    int getNumberOfColumns();

    int getNumberOfFruits();

    void setNumberOfFruits(int numberOfFruits);

    int getNumberOfRows();

    int getBarbieHealth();

    Barbie getBarbie();
}
