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


class BarbieTest {

    @Test
    void testBarbieHealthInitializedCorrectly() {
        Scout scout = new Scout();
        assertEquals(100, scout.getHealth());
    }

    @Test
    void testToString() {
        Scout scout = new Scout();
        assertEquals("\u001B[35mB\u001B[0m", scout.toString()); // may have to do a better test
    }
}