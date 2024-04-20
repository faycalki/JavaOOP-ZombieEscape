package com.faycalkilali.fruitcollectorapp.view;

public class GridView implements Viewable{
    private String contents = "";

    @Override
    public void display() {
        // Render the game map
        System.out.println(contents);
    }

    @Override
    public void inputFromController(String input) {
        contents = input;
    }
}
