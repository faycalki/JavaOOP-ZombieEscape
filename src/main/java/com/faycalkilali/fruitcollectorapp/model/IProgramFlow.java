package com.faycalkilali.fruitcollectorapp.model;

public interface IProgramFlow {

    void update();

    void moveBarbie(String direction);

    int getFruits();

    IGrid getGrid();

    boolean getGameInProgress();

    void swapGameInProgress();

    boolean isGameWon();

    void swapGameWon();

    void resetGame();
}
