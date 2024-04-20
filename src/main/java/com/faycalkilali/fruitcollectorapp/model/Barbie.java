package com.faycalkilali.fruitcollectorapp.model;

/**
 * Representation of a Barbie Person.
 * @author Faycal Kilali
 * @version 1.0
 */
public class Barbie extends Person{

    /**
     * Constructor for the class.
     */
    public Barbie(){
        this.health = 100;
    }

    /**
     * Exhibits the textual form of the object.
     * @return textual representation of the object.
     */
    @Override
    public String toString(){
        return "\u001B[35mB\u001B[0m";
    }
}
