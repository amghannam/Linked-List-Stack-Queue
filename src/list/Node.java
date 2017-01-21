/*
 * File: Node.java
 */
package list;

/**
 * Represents a singly-linked list node. 
 * 
 * @author Ahmed Ghannam
 *
 */
public class Node {
	/**
	 * The numeric value associated with this node.
	 */
	public int value; 
	
	/**
	 * The node to which this node is pointing.  
	 */
	public Node next; 
	
	/**
	 * Constructs a new node with the specified numeric value.
	 *  
	 * @param value the value of the node to be created.
	 */
	public Node(int value) {
		this.value = value; 
	}
}
