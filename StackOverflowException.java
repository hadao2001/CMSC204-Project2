package Notation;

/*
 * CMSC 204 Assignment 2
 * Class Notation
 * 
 * @author Ha T Dao
 * 
 * Description: occurs when a top or pop method is called on an empty stack.
 */

public class StackOverflowException extends RuntimeException {
    
    /**
     * No-arg constructor with default message for stack overflow
     */
    public StackOverflowException() {
        super("The empty is full");
    }
}