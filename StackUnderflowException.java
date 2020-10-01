package Notation;

/**
 *  * CMSC 204 Assignment 2
 * Class: StackUnderflowException
 * 
 * @author Ha T Dao
 * 
 * Description: StackUnderflowException Exception file. 
 * 
 * This exception is thrown when a pop or peek method is called on an empty stack.
 * 
 */
public class StackUnderflowException extends RuntimeException {
    
    /**
     * No-arg constructor with default message for stack underflow
     */
    public StackUnderflowException() {
        super("The stack is empty");
    }
}