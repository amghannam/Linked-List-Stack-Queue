/*
 * Queue.java 
 */
package queue;

import list.*; 

/**
 * Implements a queue backed by a singly-linked list. 
 * @author Ahmed Ghannam 
 *
 */
public class Queue extends LinkedList {
	/**
	 * Constructs a new Queue instance. 
	 */
	public Queue() {
		super(); 
	}
	
	/**
	 * Adds the specified value to this queue. 
	 * @param value the value to be inserted 
	 */
	public void enqueue(int value) {
		super.insertHead(value);
	}
	
	/**
	 * Removes and returns the front element of this queue. 
	 * @return the front element of this queue
	 */
	public int dequeue() {
		int front = super.getTail(); 
		super.removeTail();
		return front; 
	}
	
	/**
	 * Returns, but does not remove, the front element of the queue.
	 * @return the front element of this queue. 
	 */
	public int peek() {
		return super.getTail(); 
	}
	
	/**
	 * Returns the number of elements currently in the queue.
	 * @return the number of elements in this queue 
	 */
	public int size() {
		return super.size(); 
	}
	
	/**
	 * Checks whether the specified value is in the queue.
	 * @param value the value to search for 
	 * @return <code>true</code> if the specified value exists, <code>false</code> otherwise 
	 */
	public boolean contains(int value) {
		return super.contains(value); 
	}
	
	/**
	 * Checks whether the queue is empty. 
	 * @return <code>true</code> if the stack is empty, <code>false</code> otherwise
	 */
	public boolean isEmpty() {
		return super.isEmpty(); 
	}
	
	/**
	 * Clears the queue of all existing elements. 
	 */
	public void clear() {
		super.clear(); 
	}
	
	/**
	 * Copies the current queue contents into an array. 
	 * @return an array copy of this stack 
	 */
	public int[] toArray() {
		return super.toArray(); 
	}
	
	/**
	 * Returns a string representation of the current queue and its contents. 
	 */
	@Override
	public String toString() {
		return super.toString(); 
	}
}
