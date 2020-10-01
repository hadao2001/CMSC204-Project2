package Notation;

/*
 * CMSC 204 Assignment 2
 * Class: InvalidNotationFormatException
 * 
 * @author Ha T Dao
 * 
 * Description: InvalidNotationFormatException Exception file. 
 */
public class InvalidNotationFormatException extends RuntimeException {
    
    /**
     * No-arg constructor with default message for invalid notation format
     */
    public InvalidNotationFormatException() {
        super("Notation format is invalid");
    }
}