import java.util.*;
import java.io.*;

public class EI20213Q2_Distinct_Numbers {

	public static void main(String[] args) {
		StringBuilder outBuffer = new StringBuilder();
		HashMap<Integer, Integer> numList = new HashMap<>();
		
		int cases = reader.nextInt();
		for (int i = 0; i < cases ; i++) {
			int num = reader.nextInt();
			numList.put(num, numList.getOrDefault(num, 0) + 1);
		}
		var keys = new ArrayList<>(numList.keySet());
		keys.sort(null);
		keys.forEach((key1) -> outBuffer.append(key1 + " " + numList.get(key1) + "\n"));
		System.out.println(outBuffer);

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
