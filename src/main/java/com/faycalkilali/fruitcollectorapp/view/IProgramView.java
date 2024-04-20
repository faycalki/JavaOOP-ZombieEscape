package com.faycalkilali.fruitcollectorapp.view;

public interface IProgramView extends Viewable{

    void welcomeMessage();

    void winScreen();

    void lostScreen();

    void addView(Viewable view);
}
