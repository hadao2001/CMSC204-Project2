package Notation;

/**
 * CMSC 204 Assignment 2
 * Class: QueueUnderflowException
 * 
 * @author Ha T Dao
 * 
 * Description: QueueUnderflowException Exception file. 
 */

public class QueueUnderflowException extends RuntimeException {
    
    /**
     * No-arg constructor with default message for queue underflow
     */
    public QueueUnderflowException() {
        super("The queue is empty");
    }
}