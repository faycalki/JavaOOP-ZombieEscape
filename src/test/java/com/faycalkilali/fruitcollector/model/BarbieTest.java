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
        Barbie barbie = new Barbie();
        assertEquals(100, barbie.getHealth());
    }

    @Test
    void testToString() {
        Barbie barbie = new Barbie();
        assertEquals("\u001B[35mB\u001B[0m", barbie.toString()); // may have to do a better test
    }
}