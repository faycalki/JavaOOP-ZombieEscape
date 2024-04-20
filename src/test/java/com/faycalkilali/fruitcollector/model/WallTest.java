/*
 * © 2024 Faycal Kilali. All rights reserved.
 *
 * This collection of code, including all its contents, is the property of Faycal Kilali.
 *
 * For inquiries or permission requests, please contact Faycal Kilali at root@faycalkilali.com.
 */

package com.faycalkilali.fruitcollector.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class WallTest {

    @Test
    void testToString() {
        Wall wall = new Wall();
        assertEquals("\u001B[33mW\u001B[0m", wall.toString());
    }
}