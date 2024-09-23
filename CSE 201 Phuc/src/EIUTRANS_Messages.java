import java.util.*;
import java.io.*;

public class EIUTRANS_Messages {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int lengthMess = reader.nextInt();
		int cases = reader.nextInt();
		Map<String, String> word = new HashMap<String, String>();
		for (int i = 0; i < cases; i++) {
			String lengA = reader.next();
			String lengB = reader.next();
			word.put(lengA, lengB);
		}
		for (int i = 0; i < lengthMess; i++) {
			String mess = reader.next();
			if (word.get(mess).length() < mess.length()) {
				sb.append(word.get(mess) + " ");
			} else {
				sb.append(mess + " ");
			}
		}
		System.out.println(sb);
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
