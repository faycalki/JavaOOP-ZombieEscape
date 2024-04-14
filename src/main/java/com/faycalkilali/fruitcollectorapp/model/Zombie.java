package com.faycalkilali.fruitcollectorapp.model;

/**
 * Representation of a Zombie Object
 * @author Faycal Kilali
 * @version 1.0
 */
public class Zombie extends Person{



    /**
     * Communicates Zombie in textual form
     * @return textual representation of Zombie
     */
    public String toString(){
        return "\u001B[31mZ\u001B[0m";
    }
}
