/*
 * File: LinkedList.java 
 */
package list;

/**
 * Implements an unbounded singly-linked list of integers that supports common
 * operations such as insertion and removal, in addition to other convenience
 * methods.
 * 
 * @author Ahmed Ghannam
 *
 */
public class LinkedList {
	private Node head;
	private Node tail;
	private int size = 0;
	private static final int NOT_FOUND = -1;

	/**
	 * Constructs an empty singly-linked list, without any nodes.
	 */
	public LinkedList() {
		/* Nothing to see here. */
	}

	/**
	 * Constructs a new singly-linked list with the specified head.
	 * 
	 * @param head
	 *            the head of the list to be created
	 */
	public LinkedList(Node head) {
		this.head = head;
		this.tail = head;
		size++;
	}

	/**
	 * Constructs a new singly-linked list from the given array of integers.
	 * 
	 * @param array
	 */
	public LinkedList(int[] array) {
		if (array.length == 0)
			return;
		for (int i = 0; i < array.length; i++) {
			this.insert(array[i]);
		}
	}

	/**
	 * Appends a new node with the specified value to the end of this list. If
	 * the list is empty, this method simulates a call of <code>insertHead(val).
	 * </code>
	 * 
	 * @param val
	 *            the value to be inserted into the list
	 */
	public void insert(int val) {
		Node newNode = new Node(val);
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
	 * Deletes the first occurrence of the node containing the specified value
	 * from the list. If the target node is not found, no changes are made to
	 * the list.
	 * 
	 * @param val
	 *            the value to be removed from the list
	 */
	public void remove(int val) {
		boolean found = false;
		if (isEmpty())
			return;
		if (head.value == val) {
			removeHead();
		} else {
			Node curr = head;
			while (curr.next != null) {
				if (curr.next.value == val) {
					curr.next = curr.next.next;
					found = true;
					break;
				}
				curr = curr.next;
			}
		}
		if (found == true)
			size--;
	}

	/**
	 * Inserts a new head with the specified value into the list. If it exists,
	 * the old head becomes the second node of the list.
	 * 
	 * @param val
	 *            the value of the head to be inserted
	 */
	public void insertHead(int val) {
		Node newHead = new Node(val);
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
	 * Removes the first element of the list. If the list is empty, then the
	 * call is a no-op.
	 */
	public void removeHead() {
		if (!isEmpty()) {
			head = head.next;
			size--;
		}
	}

	/**
	 * Removes the last element of the list. If the list is empty, the call is a
	 * no-op.
	 */
	public void removeTail() {
		if (size == 1)
			removeHead();
		if (!isEmpty()) {
			Node curr = head;
			while (curr.next != tail) {
				curr = curr.next;
			}
			curr.next = curr.next.next;
			tail = curr;
			size--;
		}
	}

	/**
	 * Checks whether the specified value exists in the list.
	 * 
	 * @param value
	 *            the value to search for
	 * @return <code>true</code> if the value exists, <code>false</code>
	 *         otherwise.
	 */
	public boolean contains(int value) {
		if (isEmpty()) {
			return false;
		} else if (head.value == value || tail.value == value) {
			return true;
		} else {
			Node curr = head;
			while (curr != null) {
				if (curr.value == value) {
					return true;
				}
				curr = curr.next;
			}
		}
		return false;
	}

	/**
	 * Updates the specified value with the new replacement value. If the
	 * specified value does not exist, this method is a no-op. Note that this
	 * does *not* remove the associated node.
	 * 
	 * @param value
	 *            the value to be replaced
	 * @param replacement
	 *            the replacement value
	 */
	public void replace(int value, int replacement) {
		if (!isEmpty() && head.value == value) {
			head.value = replacement;
		} else if (!isEmpty() && tail.value == value) {
			tail.value = replacement;
		} else {
			if (contains(value)) {
				Node curr = head;
				while (curr.next.value != value) {
					curr = curr.next;
				}
				curr.next.value = replacement;
			}
		}
	}

	/**
	 * Returns the number of nodes currently in the list.
	 * 
	 * @return the number of nodes in the list
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns an array of integers containing the values of the nodes in this
	 * list.
	 * 
	 * @return an array copy of this linked list
	 */
	public int[] toArray() {
		if (isEmpty())
			return null;
		int[] array = new int[size()];
		Node curr = head;
		int i = 0;
		while (curr != null) {
			array[i++] = curr.value;
			curr = curr.next;
		}
		return array;
	}

	/**
	 * Returns the value of the element in the specified position (i.e.
	 * zero-based index) if it exists, otherwise a default value of -1 is
	 * returned.
	 * 
	 * @param position
	 *            the position of the target element
	 * @return the value of the target element
	 */
	public int get(int position) {
		if (position > size - 1)
			return NOT_FOUND;
		int[] copy = this.toArray();
		return copy[position];
	}

	/**
	 * Returns the value of the first element in the list if it is not empty,
	 * otherwise a default value of -1 is returned.
	 * 
	 * @return the head element of this list
	 */
	public int getHead() {
		if (!isEmpty()) {
			return head.value;
		}
		return NOT_FOUND;
	}
	
	/**
	 * Returns the value of the middle element in this list, or -1 if 
	 * the list is empty.
	 * 
	 * @return the value of the middle element
	 */
	public int getMiddle() {
		if (!isEmpty()) {
			Node slow = head;
			Node fast = head;
			while (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
		}
		return NOT_FOUND;
	}

	/**
	 * Returns the value of the last element in the list if it is not empty,
	 * otherwise a default value of -1 is returned.
	 * 
	 * @return the tail element of this list
	 */
	public int getTail() {
		if (!isEmpty()) {
			return tail.value;
		}
		return NOT_FOUND;
	}

	/**
	 * Clears the list of all existing nodes. The list becomes empty afterward.
	 */
	public void clear() {
		head.next = null;
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Checks whether the list is empty.
	 * 
	 * @return <code>true</code> if the list is empty, <code>false</code>
	 *         otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns a string representation of the linked list.
	 * 
	 * @return a string representation of this linked list
	 */
	@Override
	public String toString() {
		StringBuilder list = new StringBuilder();
		Node curr = head;
		while (curr != null) {
			if (curr.next == null) {
				list.append(curr.value);
			} else {
				list.append(curr.value).append(" -> ");
			}
			curr = curr.next;
		}
		return list.toString();
	}
}
