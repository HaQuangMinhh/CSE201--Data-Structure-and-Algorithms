import java.util.*;
import java.io.*;
import java.util.Scanner;
public class EILINKEA_Linked_List_SimpleVersion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		int zero = sc.nextInt();
		int m = sc.nextInt();

		for (int i = 0; i < m; i++) {
			String request = sc.next();
			switch (request) {
			case "insertAt":
				int index = sc.nextInt();
				int value = sc.nextInt();

				linkedList.insertAt(index, value);
				break;
			case "getAt":
				index = sc.nextInt();
				System.out.println(linkedList.getAt(index));
				break;
			default:
				break;
			}

		}
	}

	static class LinkedList<T extends Number> {

		static private class LinkedNode<U extends Number> {
			U number;
			LinkedNode<U> next;

			public LinkedNode(U number) {
				this.number = number;
			}
		}

		int size = -1;
		
		LinkedNode<T> head = null;

		@SuppressWarnings("unchecked")
		public void insertAt(int index, T number) {
//	    while
			@SuppressWarnings("rawtypes")
			LinkedNode newNode = new LinkedNode(number);
			if (head == null) {
				head = newNode;
				
			} else {
				newNode.next = head;
//					  .next dùng để tạo link
				head = newNode;
				
			}
			size++;
		}

		/**
		 * @return null if index is out of range
		 */
		public T getAt(int index) {
//			// Your code here
			if (size < index) {
				return null;
			}
			if (head == null) {
				return null;
			} else if (index == 0) {
				return head.number;
			} else {
				LinkedNode<T> temp = head;
				for (int i = 0; i < index; i++) {
					temp = temp.next;
				}
				return temp.number;
			}

		}

	}
}
