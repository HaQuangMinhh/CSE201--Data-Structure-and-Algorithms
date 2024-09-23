import java.util.*;
import java.io.*;

public class EI2122Q1ADAM2_Matching {

	public static void main(String[] args) {
		int numberOfMen = reader.nextInt();
		int numberOfWomen = reader.nextInt();
		int indices = reader.nextInt();
		long maxDiff = 0;
		int pair = 0;
		List<Long> hightOfMen = new ArrayList<Long>();
		List<Long> hightOfWomen = new ArrayList<Long>();

		for (int i = 0; i < numberOfMen; i++) {
			hightOfMen.add(reader.nextLong());
		}
		for (int i = 0; i < numberOfWomen; i++) {
			hightOfWomen.add(reader.nextLong());
		}

		for (int i = 0; i < hightOfMen.size(); i++) {
			for (int j = 0; j < hightOfWomen.size(); j++) {
				if (i >= hightOfMen.size()) {
					i = hightOfMen.size() - 1;
				}
				if (j >= hightOfWomen.size()) {
					j = hightOfMen.size() - 1;
				}

				long distance = Math.abs(hightOfMen.get(i) - hightOfWomen.get(j));
				if (distance > maxDiff) {
					maxDiff= distance;
				}
			}
		}

		System.out.println(maxDiff);

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