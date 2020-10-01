package Notation;

import java.util.ArrayList;
import java.util.Objects;


/**
 * CMSC 204 Assignment 2
 * Class: MyQueue
 * 
 * @author Ha T Dao
 * 
 * Description: MyQueue will implement the QueueInterface. 
 * 
 */

public class NotationQueue<T> implements QueueInterface<T> {

	/**
     * Data structure that behaves as queue
     */
	private ArrayList<T> queue;
	
	/**
     * Capacity of queue
     */
	private int size;

	/**
     * No-arg constructor with default values for the data fields.
     */
    public NotationQueue() {
        queue = new ArrayList<>();
        size = 20;
    }
    
    /**
     * One-arg constructor that instantiates queue and sets capacity value.
     * @param size maximum queue capacity
     */
	public NotationQueue(int size) {
		queue = new ArrayList<>(size);
		this.size = size;
	}

	@Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean isFull() {
        return queue.size() == size;
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        if (!isEmpty()) {
            T element = queue.get(0);
            queue.remove(0);
            return element;
        } else { 
            throw new QueueUnderflowException();
        }
    }

	@Override
	public int size() {

		return queue.size();
	}

	@Override
	public boolean enqueue(T e) throws QueueOverflowException {

		if (queue.size() == size) {
			throw new QueueOverflowException();
		}

		queue.add(e);
		return true;
	}
	
	@Override
	public String toString() {
		String s = "";
		
		for(T item: queue) {
			s += item.toString(); 
		}
		return s;
	}

	@Override
	public String toString(String delimiter) {
		String s = "";
		
		for(T item: queue) {
			s += item.toString();
			s += delimiter;
		}
		
		s = s.substring(0,s.length()-1);
		
		return s;
	}

	@Override
	public void fill(ArrayList<T> list) {
		
		queue.clear();
		
		for (T item : list) {
			queue.add(item);
		}

	}

}
