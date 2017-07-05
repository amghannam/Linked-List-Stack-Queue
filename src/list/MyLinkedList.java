/*
 * File: MyLinkedList.java
 */
package list;

/**
 * Implements an unbounded singly-linked list of integers that supports common
 * operations such as insertion and removal, in addition to other convenience
 * methods.
 * 
 * @author Ahmed Ghannam
 */
public class MyLinkedList<T> {
	private Node<T> head; 
	private Node<T> tail; 
	private int size = 0; 
	
	/**
	 * Constructs an empty instance of the linked list, without
	 * any nodes. 
	 */
	public MyLinkedList() {
		/* Empty constructor */ 
	}
	
	/**
	 * Constructs a linked list with the specified head node. 
	 * @param head the head node of the list to be created
	 */
	public MyLinkedList(Node<T> head) {
		this.head = head; 
		this.tail = head; 
		this.size++; 
	}
	
	/**
	 * Constructs a linked list containing all the elements of the specified 
	 * array.
	 * @param a the array from which to construct the list
	 */
	public MyLinkedList(T[] a) {
		if (a.length == 0) return; 
		for (int i = 0; i < a.length; i++) {
			insert(a[i]);
		}
	}
	
	/**
	 * Appends a node with the specified value to the end of this list.
	 * @param val the value of the node to be added
	 */
	public void insert(T val) {
		Node<T> newNode = new Node<>(val); 
		if (isEmpty()) {
			head = newNode; 
			tail = newNode; 
			size++; 
		} else {
			tail.next = newNode; 
			tail = newNode; 
			size++; 
		}
	}
	
	/**
	 * Removes the first occurrence of the node having the specified value 
	 * from the list. If the list is empty, the call is a no-op. 
	 * @param val the value of the node to be removed from this list
	 */
	public void remove(T val) {
		boolean found = false; 
		if (isEmpty()) return; 
		if (head.value == val) removeHead(); 
		else {
			Node<T> curr = head; 
			while (curr.next != null) {
				if (curr.next.value == val) {
					curr.next = curr.next.next; 
					found = true; 
					break; 
				}
				curr = curr.next; 
			}
		}
		if (found == true) size--; 
	}
	
	/**
	 * Appends a node with the specified value to the beginning of this list.
	 * @param val the value of the node to be added 
	 */
	public void insertHead(T val) {
		Node<T> newHead = new Node<>(val); 
		if (isEmpty()) {
			head = newHead; 
			tail = newHead;
			size++; 
		} else {
			newHead.next = head; 
			head = newHead;
			size++; 
		}
	}
	
	/**
	 * Removes the first node of this list. If the list is empty, the call 
	 * is a no-op. 
	 */
	public void removeHead() {
		if (!isEmpty()) {
			head = head.next; 
			size--; 
		}
	}
	
	/**
	 * Removes the last node of this list. If the list is empty, the call 
	 * is a no-op. 
	 */
	public void removeTail() {
		if (!isEmpty()) {
			if (size == 1) {
				removeHead();
			} else {
				Node<T> curr = head;
				while (curr.next != tail) {
					curr = curr.next;
				}
				if (curr.next == tail) {
					curr.next = null;
					tail = curr;
					size--;
				}
			}
		}
	}
	
	/**
	 * Returns <code>true</code> if and only if the list contains a node with 
	 * the specified value. 
	 * @param val the value of the node to search for 
	 * @return <code>true</code> if the list contains the target, 
	 * <code>false</code> otherwise
	 */
	public boolean contains(T val) {
		if (isEmpty()) return false; 
		else if (head.value == val || tail.value == val) {
			return true; 
		} else {
			Node<T> curr = head.next;
			while (curr != tail) {
				if (curr.value == val) return true; 
				curr = curr.next; 
			}
		}
		return false; 
	}
	
	/**
	 * Returns the value of the first node in this list. 
	 * @return the value of the head node 
	 */
	public T getHead() {
		if (!isEmpty()) {
			return head.value; 
		}
		return null; 
	}
	
	/**
	 * Returns the value of the middle node in this list. 
	 * @return the value of the middle node
	 */
	public T getMiddle() {
		if (!isEmpty()) {
			Node<T> slow = head;
			Node<T> fast = head; 
			while (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next; 
			}
			return slow.value; 
		}
		return null; 
	}
	
	/**
	 * Returns the value of the last node in this list. 
	 * @return the value of the tail node 
	 */
	public T getTail() {
		if (!isEmpty()) {
			return tail.value; 
		}
		return null; 
	}
	
	/**
	 * Removes all nodes from the list and resets its size.
	 */
	public void clear() {
		head.next = null;
		head = null; 
		tail = null;
		size = 0; 
	}
	
	/**
	 * Returns <code>true</code> if and only this list is empty. 
	 * @return <code>true</code> if the list is empty, <code>false</code> 
	 * otherwise 
	 */
	public boolean isEmpty() {
		return size == 0;  
	}
	
	/**
	 * Returns the current size of this list. 
	 * @return the number of nodes currently in the list
	 */
	public int size() {
		return size; 
	}
	
	/**
	 * Returns a string representation of this list. 
	 * @return a string representation of this list
	 */
	@Override
	public String toString() {
		Node<T> curr = head; 
		StringBuilder list = new StringBuilder(); 
		while (curr != tail) {
			list.append(curr.value).append(" -> "); 
			curr = curr.next; 
		}
		list.append(curr.value); 
		return list.toString(); 
	}
}
