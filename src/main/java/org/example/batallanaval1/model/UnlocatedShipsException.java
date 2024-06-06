package org.example.batallanaval1.model;

/**
 * An exception thrown when there are unlocated ships.
 */
public class UnlocatedShipsException extends Exception{
    /**
     * Constructs a new UnlocatedShipsException with the specified detail message.
     *
     * @param message the detail message
     */
    public UnlocatedShipsException(String message){super(message);}

}
