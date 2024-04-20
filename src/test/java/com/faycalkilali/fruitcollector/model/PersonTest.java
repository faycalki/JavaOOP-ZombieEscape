/*
 * © 2024 Faycal Kilali. All rights reserved.
 *
 * This collection of code, including all its contents, is the property of Faycal Kilali.
 *
 * For inquiries or permission requests, please contact Faycal Kilali at root@faycalkilali.com.
 */

package com.faycalkilali.fruitcollector.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Barbie();
    }

    @Test
    void testGetHealth() {
        assertEquals(100, person.getHealth());
    }

    @Test
    void testSetHealth() {
        person.setHealth(50);
        assertEquals(50, person.getHealth());
    }

    @Test
    void testResetToDefault() {
        person.setHealth(50);
        person.resetToDefault();
        assertEquals(100, person.getHealth());
    }
}