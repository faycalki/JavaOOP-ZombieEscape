/*
 * © 2024 Faycal Kilali. All rights reserved.
 *
 * This collection of code, including all its contents, is the property of Faycal Kilali.
 *
 * For inquiries or permission requests, please contact Faycal Kilali at root@faycalkilali.com.
 */

package com.faycalkilali.fruitcollector.controller;

import com.faycalkilali.fruitcollector.view.HeadUpDisplayView;
import com.faycalkilali.fruitcollector.view.Viewable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeadUpDisplayControllerTest {

    private HeadUpDisplayController hudController;

    @BeforeEach
    void setUp() {
        hudController = new HeadUpDisplayController();
    }

    @Test
    void testGetView() {
        Viewable view = hudController.getView();
        assertNotNull(view);
        assertTrue(view instanceof HeadUpDisplayView);
    }


}