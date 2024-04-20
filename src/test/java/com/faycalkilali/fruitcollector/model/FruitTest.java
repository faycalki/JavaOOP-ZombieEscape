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


class FruitTest {

    @Test
    void testToString() {
        Fruit fruit = new Fruit();
        assertEquals("\u001B[32mF\u001B[0m", fruit.toString());
    }
}
