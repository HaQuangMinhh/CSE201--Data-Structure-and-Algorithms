import java.util.*;
import java.io.*;

public class EIUGIFT1_GiftWrapping {

	public static void main(String[] args) {
		int sumOfGift = reader.nextInt();
		int[] listOfGift = new int[sumOfGift];
		int sumOfPaper = reader.nextInt();
		int[] listOfPaper = new int[sumOfPaper];
		int totalPaper = 0;
		for (int i = 0; i < listOfGift.length; i++) {
			listOfGift[i] = reader.nextInt();
		}
		for (int i = 0; i < listOfPaper.length; i++) {
			listOfPaper[i] = reader.nextInt();
		}
		Arrays.sort(listOfGift);
		Arrays.sort(listOfPaper);

		for (int i = 0, j = 0; i < listOfGift.length && j< listOfPaper.length; i++, j++) {
			if((double)listOfPaper[j] / listOfGift[i] >= 2 && (double)listOfPaper[j] / listOfGift[i] <= 3) {
				totalPaper++;
			} else if((double)listOfPaper[j] / listOfGift[i] < 2) {
				i--;
			}else j--;
		}
		System.out.println(totalPaper);

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
