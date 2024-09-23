import java.util.*;
import java.io.*;

public class EIUBISEA_Binary_search {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int toltalOfNumbers = reader.nextInt();
		int totalFinding = reader.nextInt();
		int[] listOfNumber = new int[toltalOfNumbers];

		for (int i = 0; i < listOfNumber.length; i++) {
			listOfNumber[i] = reader.nextInt();
		}
		Arrays.sort(listOfNumber);

		for (int i = 0; i < totalFinding; i++) {
			int key = reader.nextInt();
			sb.append(binarySearch(listOfNumber, key) + " ");
		}

		System.out.println(sb);
	}

	static int binarySearch(int[] numbers, int key) {

		int left = 0, right = numbers.length;
		while (right - left > 1) {
			int middle = (left + right) / 2;
			if (numbers[middle] < key) {
				left = middle + 1;
			} else if (numbers[middle] > key) {
				right = middle;
			} else {
				if (numbers[middle - 1] == key) {
					for (int i = left; i < middle; i++) {
						if (numbers[i] == key) {
							return i;
						}
					}
				}else return middle;
			}
		}
		if (left < numbers.length && numbers[left] == key) {
			return left;
		} else
			return -1;
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
