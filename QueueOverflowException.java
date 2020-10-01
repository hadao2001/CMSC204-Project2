package Notation;

/**
 * * CMSC 204 Assignment 2
 * Class: QueueOverflowException
 * 
 * @author Ha T Dao
 * 
 * Description: QueueOverflowException Exception file. 
 * 
 * This exception is thrown when an enqueue method is called on a full queue.
 * 
 */
public class QueueOverflowException extends RuntimeException {
    
    /**
     * No-arg constructor with default message for queue overflow
     */
    public QueueOverflowException() {
        super("The queue is full");
    }
}
