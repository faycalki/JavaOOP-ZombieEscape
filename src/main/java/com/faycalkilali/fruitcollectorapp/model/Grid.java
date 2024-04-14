package com.faycalkilali.fruitcollectorapp.model;

public class Grid implements IGrid{





    /**
     * Textual representation of the grid and objects within it
     * @return the representation of the grid and objects within it
     */
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                Object cell = grid[row][column];
                if (cell == null) {
                    result.append("\u001B[37mX\u001B[0m\t");
                } else {
                    result.append(cell.toString()).append("\t"); // we'll call the toString of that method
                }
            }
            result.append("\n");
        }

        return result.toString();
    }


}
