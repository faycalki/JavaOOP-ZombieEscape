package com.faycalkilali.fruitcollectorapp.view;

public interface IProgramView extends Viewable{

    public void welcomeMessage();

    public void winScreen();

    public void lostScreen();

    public void addView(Viewable view);
}
