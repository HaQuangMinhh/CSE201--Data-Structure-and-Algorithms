import java.util.*;
import java.io.*;

public class EIUGIFTS_Women_day {

	public static void main(String[] args) {
		int items = reader.nextInt();
		int money = reader.nextInt();
		int maxMoney = 0;
		int minDifference = money;

		int[] priceOfItems = new int[items];
		for (int i = 0; i < items; i++) {
			priceOfItems[i] = reader.nextInt();
		}
		Arrays.sort(priceOfItems);

		for (int i = 0, j = priceOfItems.length - 1; i < priceOfItems.length && j > i; i++, j--) {
			int sumMoney = priceOfItems[i] + priceOfItems[j];
			int gap = Math.abs(priceOfItems[i] - priceOfItems[j]);

			if (sumMoney <= money) {
				if (sumMoney >= maxMoney) {
					maxMoney = sumMoney;
					minDifference = gap;
				}
			}
			if (sumMoney > money) {
				i--;
			} else {
				j++;
			}
		}

		if (maxMoney == 0 && minDifference == money) {
			System.out.println(-1 + " " + -1);
		} else
			System.out.println(maxMoney + " " + minDifference);
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
