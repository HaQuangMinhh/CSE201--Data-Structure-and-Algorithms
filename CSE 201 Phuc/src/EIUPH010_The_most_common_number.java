import java.util.*;
import java.io.*;

public class EIUPH010_The_most_common_number {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int cases = reader.nextInt();

		HashMap<Integer, Integer> numList = new HashMap<>();
		for (var i = 0; i < cases; i++) {
			int num = reader.nextInt();
			numList.put(num, numList.getOrDefault(num, 0) + 1);
		}
		
		int numMin = 0;
		int commonMax = 0;
		for (int i : numList.keySet()) {
			if (numList.get(i) > commonMax) {
				if (numMin < i) {
					numMin = i;
					commonMax = numList.get(i);
				} else {
					numMin = i;
					commonMax = numList.get(i);
				}
			}			
		}
		System.out.println(numMin + " " + commonMax);
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
