package Notation;

import java.util.ArrayList;
import java.util.Stack;

/**
 * CMSC 204 Assignment 2
 * Class: MyStack
 * 
 * @author Ha T DAo
 * 
 * Description: MyStack will implement the StackInterface. 
 * Implementation of a generic stack data structure.
 
 * @param <T> data type
 */

public class NotationStack<T> implements StackInterface<T> {
    
	/**
     * Data structure that behaves as stack
     */
	private ArrayList<T> stack;
	
	/**
     * Capacity of stack
     */
	private int size; 
	
	/**
     * No-arg constructor with default values for the data fields.
     */
	public NotationStack() {

		stack = new ArrayList<>();
		size = 20;
	}
	
	/**
     * One-arg constructor that instantiates queue and sets capacity value.
     * @param capacity maximum stack capacity
     */
	NotationStack(int capacity) {

		stack = new ArrayList<>(capacity);
		this.size = capacity;

	}
	
	/**
	 * isEmpty
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
        return stack.isEmpty();
    }
	

	/**
	 * isFull
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
    public boolean isFull() {
        return stack.size() == size;
    }
	

	@Override
    public T pop() throws StackUnderflowException {
        if (!isEmpty()) {
            T element = stack.get(size() - 1);
            stack.remove(size() - 1);
            return element;
        } else { 
            throw new StackUnderflowException();
        }
    }
	
	@Override
	public T top() throws StackUnderflowException{
		if (stack.size() == 0) {
			throw new StackUnderflowException();
		}
		return stack.get(stack.size()-1);
	}


	public T peek() throws StackUnderflowException {
        if (!isEmpty()) {
            return stack.get(size() - 1);
        } else {
            throw new StackUnderflowException();
        }
    }

	@Override
	public int size() {
		return stack.size();
	}

	@Override
    public boolean push(T e) throws StackOverflowException {
        if (!isFull()) {
            return stack.add(e);
        } else {
            throw new StackOverflowException();
        }
    }
	
	@Override
	public String toString() {
	String s = "";
		
		for(T item: stack) {
			s += item.toString(); 
		}
		return s;
		
	}

	@Override
	public String toString(String delimiter) {
		String s = "";
		
		for(T item: stack) {
			s += item.toString();
			s += delimiter;
		}
		
		s = s.substring(0,s.length()-1);
		
		return s;
	}

	@Override
	public void fill(ArrayList<T> list) {
		
		stack.clear();

		for (T item : list) {
		
			stack.add(item);
		}

		
	}



}
