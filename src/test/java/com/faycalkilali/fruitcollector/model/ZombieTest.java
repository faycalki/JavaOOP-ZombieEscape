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

class ZombieTest {

    @Test
    void testToString() {
        Zombie zombie = new Zombie();
        assertEquals("\u001B[31mZ\u001B[0m", zombie.toString());
    }
}
