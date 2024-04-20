package com.faycalkilali.fruitcollectorapp.model;

public interface IGrid {


    void initializeGrid();

    Entity[][] getGrid();

    int getBarbieColumn();

    int getBarbieRow();

    int getNumberOfColumns();

    int getNumberOfFruits();

    int getNumberOfRows();

    int getBarbieHealth();

    Barbie getBarbie();

    void setBarbieColumn(int barbieColumn);

    void setBarbieRow(int barbieRow);

    void setNumberOfFruits(int numberOfFruits);
}
