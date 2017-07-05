/*
 * File: Node.java
 */
package list;

/**
 * Represents a linked list node. 
 * 
 * @author Ahmed Ghannam
 */
public class Node<T> {
	/**
	 * The node to which this node is pointing. 
	 */
	public Node<T> next; 
	
	/**
	 * The value or data associated with this node. 
	 */
	public T value; 
	
	/**
	 * Constructs a new linked list node with the specified value. 
	 * @param value the value to be associated with this node 
	 */
	public Node(T value) {
		this.value = value; 
	}
}
