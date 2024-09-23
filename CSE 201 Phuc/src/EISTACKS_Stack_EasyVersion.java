import java.io.*;
import java.util.*;

public class EISTACKS_Stack_EasyVersion {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();
		int m = reader.nextInt();
		int testCase = reader.nextInt();
		ArrayStack<Integer> stack = new ArrayStack<Integer>(n);
		for (int i = 0; i < m; i++) {
			stack.push(reader.nextInt());
		}
		for (; testCase > 0; testCase--) {
			String request = reader.next();
			switch (request) {
			case "peek":
				sb.append(stack.peek() + "\n");
				break;
			case "sum":
				sb.append(stack.sum() + "\n");
				break;
			case "average":
				sb.append(stack.average() + "\n");
				break;
			case "pop":
				sb.append(stack.pop() + "\n");
				break;
			case "push":
				int number = reader.nextInt();
				stack.push(number);
				break;
			default:
				break;
			}
		}
		System.out.println(sb);
	}

	static class ArrayStack<T extends Number> {

		// Your code here
		Object[] data;
		int lastIndex = 0;
		long sum = 0;

		public ArrayStack(int capacity) {
			data = new Object[capacity];
		}

		public int count() {
			return lastIndex;
		}

		public double sum() {
			return (double) sum;
		}

		public double average() {

			return this.sum() * 1.0 / this.count();
		}

		/**
		 * @description: add item when stack is not full
		 */
		public void push(T item) {
			data[lastIndex++] = item;
			sum += (int) item;
		}

		/**
		 * @return: return and remove top item, or null when stack is empty
		 */

		@SuppressWarnings("unchecked")
		public T pop() {
			if (lastIndex != 0) {
				sum -= (int) data[lastIndex - 1];
				return (T) data[lastIndex-- - 1];
			}
			return null;
		}

		/**
		 * @return: return top item, or null when stack is empty
		 */
		@SuppressWarnings("unchecked")
		public T peek() {
			if (lastIndex == 0) {
				return null;
			} else {
				return (T) data[lastIndex - 1];
			}
		}
	}

	static InputReader reader = new InputReader(System.in);

	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {

			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}
				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
