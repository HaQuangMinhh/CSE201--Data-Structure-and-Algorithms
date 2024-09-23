import java.util.*;
import java.io.*;

public class EIPAGES_Page_numbers {

	public static void main(String[] args) {
		int cases = reader.nextInt();
		int[] arr = new int[cases];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = reader.nextInt();
		}
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			int j = i + 1;
			for (; j < arr.length; j++) {
				count++;
				if (arr[j] - arr[i] != j - i) {
					j--;
					break;
				}
			}
			if (count > 2) {
				System.out.print(arr[i] + "-" + arr[j] + " ");
				i = j;
			} else {
				System.out.print(arr[i] + " ");

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
