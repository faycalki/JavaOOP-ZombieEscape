/*
 * © 2024 Faycal Kilali. All rights reserved.
 *
 * This collection of code, including all its contents, is the property of Faycal Kilali.
 *
 * For inquiries or permission requests, please contact Faycal Kilali at root@faycalkilali.com.
 */

package com.faycalkilali.fruitcollector.model;

/**
 * Representation of a Scout Person.
 *
 * @author Faycal Kilali
 * @version 1.0
 */
public class Scout extends Person {

    /**
     * Constructor for the class.
     */
    public Scout() {
        this.health = 100;
    }

    /**
     * Exhibits the textual form of the object.
     *
     * @return textual representation of the object.
     */
    @Override
    public String toString() {
        return "\uD83D\uDC68\u200D\uD83D\uDE80\u001B[0m"; // Astronaut (Man)
    }
}
