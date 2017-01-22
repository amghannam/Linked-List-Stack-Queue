/*
 * File: Stack.java 
 */
package stack;

import list.*; 

/**
 * Implements a stack based on a singly-linked list. 
 * @author Ahmed Ghannam 
 *
 */
public class Stack extends LinkedList {
	
	/**
	 * Constructs a new Stack instance. 
	 */
	public Stack() {
		super(); 
	}
	
	/**
	 * Pushes the specified value onto the top of the stack. 
	 * @param value the value to be pushed into the stack 
	 */
	public void push(int value) {
		super.insertHead(value);
	}
	
	/**
	 * Removes and returns the top element of the stack. 
	 * @return the top element of the stack 
	 */
	public int pop() {
		int top = super.getHead(); 
		super.removeHead();
		return top; 
	}
	
	/**
	 * Returns, but does not remove, the top of the stack. 
	 * @return the top of the stack 
	 */
	public int peek() {
		return super.getHead(); 
	}
	
	/**
	 * Returns the number of elements currently in the stack. 
	 * @return the number of elements in the stack 
	 */
	public int size() {
		return super.size(); 
	}
	
	/**
	 * Checks whether the specified value is in the stack.
	 * @param value the value to search for 
	 * @return <code>true</code> if the specified value exists, <code>false</code> otherwise 
	 */
	public boolean contains(int value) {
		return super.contains(value); 
	}
	
	/**
	 * Checks whether the stack is empty. 
	 * @return <code>true</code> if the stack is empty, <code>false</code> otherwise
	 */
	public boolean isEmpty() {
		return super.isEmpty(); 
	}
	
	/**
	 * Clears the stack of all existing elements. 
	 */
	public void clear() {
		super.clear(); 
	}
	
	/**
	 * Copies the current stack contents into an array. 
	 * @return an array copy of this stack 
	 */
	public int[] toArray() {
		return super.toArray(); 
	}
	
	/**
	 * Returns a string representation of the current stack and its contents. 
	 */
	@Override
	public String toString() {
		return super.toString(); 
	}
}
