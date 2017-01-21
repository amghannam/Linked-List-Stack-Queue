/*
 * Test.java 
 */
package list;

/**
 * Quick black-box test of the LinkedList class. 
 * 
 * @author Ahmed
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = new LinkedList(new int[] {4, 10, 3, 19, 41, 23, 76, 902}); 
		System.out.println(list.toString());
		list.removeTail();
		System.out.println(list.toString());		
		list.insert(100);
		System.out.println(list.toString());
		list.replace(list.get(4), 50);
		System.out.println(list.toString());
		list.remove(50);
		System.out.println(list.toString()); 
		list.insert(250);
		System.out.println(list.contains(19)); 
    //...
	}
}
