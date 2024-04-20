/*
 * © 2024 Faycal Kilali. All rights reserved.
 *
 * This collection of code, including all its contents, is the property of Faycal Kilali.
 *
 * For inquiries or permission requests, please contact Faycal Kilali at root@faycalkilali.com.
 */

package com.faycalkilali.fruitcollector.model;

/**
 * Representation of a Barbie Person.
 *
 * @author Faycal Kilali
 * @version 1.0
 */
public class Barbie extends Person {

    /**
     * Constructor for the class.
     */
    public Barbie() {
        this.health = 100;
    }

    /**
     * Exhibits the textual form of the object.
     *
     * @return textual representation of the object.
     */
    @Override
    public String toString() {
        return "\u001B[35mB\u001B[0m";
    }
}
