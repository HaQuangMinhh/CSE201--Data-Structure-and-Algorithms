import java.util.*;
import java.io.*;

public class EIPAIR_Buy_gifts {

	public static void main(String[] args) {
		long cases = reader.nextLong();
		long count = 0;

		for (int k = 0; k < cases; k++) {
			long numberOfGifts = reader.nextLong();
			HashMap<Integer, Integer> priceOfGrifts = new HashMap<>();
			for (int i = 0; i < numberOfGifts; i++) {
				int price = reader.nextInt();
				priceOfGrifts.put(price, priceOfGrifts.getOrDefault(price, 0) + 1);
			}
			count = 0;
			for (int j : priceOfGrifts.keySet()) {
				count += (long)priceOfGrifts.get(j)*((long)priceOfGrifts.get(j)-1)/2;
			}
			System.out.println(count);
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