/*
 * © 2024 Faycal Kilali. All rights reserved.
 *
 * This collection of code, including all its contents, is the property of Faycal Kilali.
 *
 * For inquiries or permission requests, please contact Faycal Kilali at root@faycalkilali.com.
 */

package com.faycalkilali.fruitcollector.model;

public interface IProgramFlow {


    void moveBarbie(String direction);


    IGrid getGrid();

    boolean getGameInProgress();

    void swapGameInProgress();

    boolean isGameWon();

    void swapGameWon();

    void resetGame();

    int getHighScore();

    int getScore();
}
