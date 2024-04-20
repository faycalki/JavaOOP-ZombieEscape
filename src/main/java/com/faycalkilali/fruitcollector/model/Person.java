/*
 * © 2024 Faycal Kilali. All rights reserved.
 *
 * This collection of code, including all its contents, is the property of Faycal Kilali.
 *
 * For inquiries or permission requests, please contact Faycal Kilali at root@faycalkilali.com.
 */

package com.faycalkilali.fruitcollector.model;

/**
 * Representation of a General Person.
 *
 * @author Faycal Kilali
 * @version 1.0
 */
abstract public class Person implements Entity {
    private static final int DEFAULT_HEALTH = 100;
    public int health;

    /**
     * Accessor for health.
     *
     * @return health of person.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Mutator for health.
     *
     * @param health to set.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Resets person's state to default.
     */
    public void resetToDefault() {
        this.health = DEFAULT_HEALTH;
    }

    /**
     * Provides a representation of the Person in textual form
     *
     * @return representation of the person
     */
    @Override
    public String toString() {
        return "\u001B[36mP\u001B[0m";
    }
}
