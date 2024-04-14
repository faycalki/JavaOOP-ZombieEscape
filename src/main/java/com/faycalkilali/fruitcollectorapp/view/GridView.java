package com.faycalkilali.fruitcollectorapp.view;

public class GridView implements Viewable{
    private String contents = "";

    @Override
    public void render() {
        // Print the game map
        System.out.println(controller.getGrid());
    }

    @Override
    public void inputFromController(String input) {

    }
}
