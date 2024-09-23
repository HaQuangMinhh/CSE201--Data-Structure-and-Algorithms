

import java.io.*;
import java.util.*;

public class EIAPPLEBOX {

	static InputReader rd = new InputReader(System.in);
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		int testNum = rd.nextInt();

		for (; testNum > 0; testNum--) {
			int N = rd.nextInt();
			int A = rd.nextInt();
			long P = rd.nextLong();

			long[] listNum = new long[N];

			listNum[0] = (A * (long) A) % P;
 
			for (int i = 1; i < N; i++) {
				listNum[i] = (listNum[i - 1] * A) % P;
			}

			mergeSort(listNum);
			long count = mergeSort(listNum, 0, N);

			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

	static long[] temp;

	public static void mergeSort(long[] numbers) {
		temp = new long[numbers.length];
	}

	public static long mergeSort(long[] numbers, int left, int right) {
		long count = 0;
		if (right > left) {
			int middle = (left + right) / 2;

			if (left < middle - 1)
				count += mergeSort(numbers, left, middle);
			if (middle < right - 1)
				count += mergeSort(numbers, middle, right);
			count += merge(numbers, left, middle, right);

		}
		return count;

	}

	private static int merge(long[] numbers, int left, int middle, int right) {
		int i = left, j = middle;
		int k = left;
		int count = 0;

		while (i < middle || j < right) {
			if (j == right || (i < middle && numbers[i] <= numbers[j])) {
				temp[k++] = numbers[i++];
			} else {
				temp[k++] = numbers[j++];
				count = count + (middle - i);
			}
		}

		for (int l = left; l < k; l++) {
			numbers[l] = temp[l];
		}
		return count;
	}

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
