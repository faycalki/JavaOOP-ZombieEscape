/*
 * © 2024 Faycal Kilali. All rights reserved.
 *
 * This collection of code, including all its contents, is the property of Faycal Kilali.
 *
 * For inquiries or permission requests, please contact Faycal Kilali at root@faycalkilali.com.
 */

package com.faycalkilali.fruitcollector.controller;

import com.faycalkilali.fruitcollector.model.Entity;
import com.faycalkilali.fruitcollector.model.IGrid;
import com.faycalkilali.fruitcollector.view.GridView;
import com.faycalkilali.fruitcollector.view.Viewable;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for managing the grid view component in the MVC architecture.
 *
 * @author Faycal Kilali
 * @version 1.1
 */
public class GridController implements IGridController {

    private final Viewable gridView;
    private IGrid grid;

    // Map terrain codes to their respective environments
    private final String[] terrainEnvironments = {
            "\uD83E\uDD32", // Deciduous tree for forest
            "\uD83E\uDD34", // Palm tree for desert
            "\uD83C\uDF0A", // Wave for sea
            "\uD83C\uDF03", // Night with stars for plains
            "\uD83C\uDF06", // Fog for marsh
            "\uD83C\uDF0D", // Volcano for volcanic area
            "\uD83C\uDF42", // Herb for grassland
            "\uD83C\uDF37", // Tulip for flower field
            "\uD83C\uDF39", // Rose for garden
            "\uD83C\uDF3A"  // Sunflower for sunflower field
    };

    /**
     * Constructs a new GridController object.
     * <p>
     * This constructor initializes a new instance of the GridController class.
     * The constructor creates a new instance of the GridView class to manage the graphical representation of the grid through the MVC architecture.
     * </p>
     */
    public GridController() {
        gridView = new GridView();
    }

    /**
     * Prepares the Grid and its contents for the View.
     */
    @Override
    public void parseGrid() {
        StringBuilder result = new StringBuilder();

        for (int row = 0; row < grid.getNumberOfRows(); row++) {
            for (int column = 0; column < grid.getNumberOfColumns(); column++) {
                Entity cell = grid.getGrid()[row][column];
                if (cell == null) {
                    // If the cell is empty, check for clustering
                    List<Entity> cluster = getCluster(row, column);
                    if (!cluster.isEmpty()) {
                        Entity clusterEntity = cluster.get(0);
                        int terrainIndex = grid.getCurrentTerrain() % terrainEnvironments.length;
                        String terrain = terrainEnvironments[terrainIndex];
                        result.append(terrain).append("\t");
                    } else {
                        result.append(terrainEnvironments[grid.getCurrentTerrain()] + "\u001B[0m" + "\t");
                    }
                } else {
                    result.append(cell).append("\t");
                }
            }
            result.append("\n");
        }

        gridView.inputFromController(result.toString());
    }

    /**
     * Retrieves the cluster of entities surrounding a specified position.
     *
     * @param row    The row index of the position.
     * @param column The column index of the position.
     * @return The list of entities in the cluster.
     */
    private List<Entity> getCluster(int row, int column) {
        List<Entity> cluster = new ArrayList<>();
        int radius = 1; // Radius to check for clustering
        for (int i = row - radius; i <= row + radius; i++) {
            for (int j = column - radius; j <= column + radius; j++) {
                if (i >= 0 && i < grid.getNumberOfRows() && j >= 0 && j < grid.getNumberOfColumns() && !(i == row && j == column)) {
                    Entity neighbor = grid.getGrid()[i][j];
                    if (neighbor != null) {
                        cluster.add(neighbor);
                    }
                }
            }
        }
        return cluster;
    }

    /**
     * Accessor for the View component.
     *
     * @return the Viewable object.
     */
    @Override
    public Viewable getView() {
        return gridView;
    }

    /**
     * Mutator for the grid.
     *
     * @param grid to mutate to.
     */
    @Override
    public void setGrid(IGrid grid) {
        this.grid = grid;
    }

}
