package com.faycalkilali.fruitcollectorapp.model;

/**
 * Representation of a General Person
 * @author Faycal Kilali
 * @version 1.0
 */
public class Person {


    public int health;

    public Person(){
        this.health = 100;
    }

    /**
     * Accessor Method for health
     * @return health of person
     */
    public int getHealth() {
        return health;
    }

    /**
     * Mutator method for health
     * @param health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }
}
