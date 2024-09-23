
//Chưa xong
import java.util.*;
import java.io.*;

public class EILINKED_Linked_List {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int t = ni();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		int totalNum = ni();
		int numOfCommand = ni();

		for (int i = 0; i < totalNum; i++) {
			int number = ni();
			linkedList.insertAt(i, number);
		}

		for (int i = 0; i < numOfCommand; i++) {
			String request = ns();
			switch (request) {
			case "sum":
				sb.append(linkedList.sum() + "\n");
//				System.out.println(linkedList.sum());
				break;
			case "average":
				sb.append(linkedList.average() + "\n");
//				System.out.println(linkedList.average());
				break;
			case "getAt":
				int index = ni();
				sb.append(linkedList.getAt(index) + "\n");
//				System.out.println(linkedList.getAt(index));
				break;
			case "size":
				sb.append(linkedList.size() + "\n");
//				System.out.println(linkedList.size());
				break;
			case "firstIndexOf":
				int num = ni();
				sb.append(linkedList.firstIndexOf(num) + "\n");
//				System.out.println(linkedList.firstIndexOf(num));
				break;
			case "lastIndexOf":
				num = ni();
				sb.append(linkedList.lastIndexOf(num) + "\n");
//				System.out.println(linkedList.lastIndexOf(num));
				break;
			case "removeFirst":
				num = ni();
				linkedList.removeFirst(num);
//				linkedList.display();
				break;
			case "removeAt":
				num = ni();
				linkedList.removeAt(num);
				linkedList.display();
				break;
			case "insertAt":
				index = ni();
				int number = ni();
				linkedList.insertAt(index, number);
//				linkedList.display();
				break;
			default:
				break;
			}
		}
		System.out.println("Hello");
		System.out.println(sb);
//		
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

		private int compare(T n1, T n2) {
			long l1 = n1.longValue();
			long l2 = n2.longValue();
			if (l1 != l2) {
				return (l1 < l2 ? -1 : 1);
			}
			return Double.compare(n1.doubleValue(), n2.doubleValue());
		}

		public int size() {
			return (size + 1);
		}

		public void add(T number) {
			LinkedNode<T> newNode = new LinkedNode<T>(number);
			// Your code here
		}

		/**
		 * @return -1 if number is not in list
		 */
		public int firstIndexOf(T number) {
			for (int i = 0; i < size(); i++) {
				if (getAt(i) == number) {
					return i;
				}
			}
			return -1;
		}

		/**
		 * @return -1 if number is not in list
		 */
		public int lastIndexOf(T number) {
			int index = -1;
			for (int i = 0; i < size(); i++) {
				if (getAt(i) == number) {
					index = i;
				}
			}
			if (index != -1) {
				return index;
			} else
				return -1;
		}

		/**
		 * Remove first occurence of number
		 */
		public void removeFirst(T number) {
			if (firstIndexOf(number) != -1) {
				removeAt(firstIndexOf(number));
			}
		}

		public void removeAt(int index) {
			LinkedNode<T> removeIndex = head;
			if (index == 0) {
				head = head.next;
				size--;
			} else if (index <= size) {
				for (int i = 0; i < index - 1; i++) {
					removeIndex = removeIndex.next;
				}
				LinkedNode<T> remove = removeIndex.next;
				LinkedNode<T> after = remove.next;
				removeIndex.next = after;
				size--;
			}

		}

		public void insertAt(int index, T number) {
//		    while
			LinkedNode newNode = new LinkedNode(number);
			if (head == null) {
				head = newNode;

			} else if (index == 0) {
				newNode.next = head;
//				.next dùng để tạo link
				head = newNode;

			} else {
				LinkedNode<T> current = head;
				for (int i = 0; i < index - 1; i++) {
					current = current.next;
				}
				LinkedNode<T> after = current.next;
				newNode.next = after;
				current.next = newNode;
			}
			size++;
		}

		/**
		 * @return null if index is out of range
		 */
		public T getAt(int index) {
			LinkedNode<T> temp = head;
			if (index > size || index < 0) {
				return null;
			}
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			return temp.number;
		}

		public double sum() {
			double sum = 0;
			for (int i = 0; i < size(); i++) {
				sum += (int) getAt(i);
			}
			return sum;
		}

		public double average() {
			double ave = sum() / size();
			return ave;
		}

		public void display() {
			if (head == null) {
				System.out.println("No value");
			} else {
				LinkedNode<T> current = head;
				while (current != null) {
					System.out.print(current.number + " ");
					current = current.next;
				}
				System.out.println();
			}
		}
	}

//	static InputReader reader = new InputReader(System.in);

	static InputStream is = System.in;
	static byte[] inbuf = new byte[1 << 24];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static double nd() {
		return Double.parseDouble(ns());
	}

	static char nc() {
		return (char) skip();
	}

	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
}
