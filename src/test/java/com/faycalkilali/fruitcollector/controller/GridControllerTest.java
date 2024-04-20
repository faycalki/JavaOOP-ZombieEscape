package com.faycalkilali.fruitcollector.controller;

import com.faycalkilali.fruitcollector.view.GridView;
import com.faycalkilali.fruitcollector.view.Viewable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GridControllerTest {

    private GridController gridController;

    @BeforeEach
    void setUp() {

        gridController = new GridController();
    }

    @Test
    void testGetView() {
        Viewable view = gridController.getView();
        assertNotNull(view);
        assertTrue(view instanceof GridView);
    }

}
