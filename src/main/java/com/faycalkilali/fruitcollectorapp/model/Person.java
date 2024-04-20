package com.faycalkilali.fruitcollectorapp.model;

/**
 * Representation of a General Person.
 * @author Faycal Kilali
 * @version 1.0
 */
abstract public class Person implements Entity {
    public int health;
    private static final int DEFAULT_HEALTH = 100;

    /**
     * Accessor for health.
     * @return health of person.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Mutator for health.
     * @param health to set.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Resets person's state to default.
     */
    public void resetToDefault(){
        this.health = DEFAULT_HEALTH;
    }

    /**
     * Provides a representation of the Person in textual form
     * @return representation of the person
     */
    @Override
    public String toString() {
        return "\u001B[36mP\u001B[0m";
    }
}
