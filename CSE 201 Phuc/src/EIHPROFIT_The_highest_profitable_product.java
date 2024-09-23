import java.util.*;

import java.io.*;
//String.format("%3f",a);

public class EIHPROFIT_The_highest_profitable_product {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int cases = reader.nextInt();
		int topHighest = reader.nextInt();

		Map<Integer, Product> listOfProducts = new HashMap<Integer, Product>();

		for (int i = 0; i < cases; i++) {
			int identity = reader.nextInt();
			String name = reader.next();
			long price = reader.nextLong();
			long cost = reader.nextLong();
			long quantity = reader.nextLong();
			Product product = new Product(identity, name, price, cost, quantity);
			listOfProducts.put(product.identity, product);
		}

		List<Product> products = new ArrayList<>(listOfProducts.values());
		products.sort((p1, p2) -> (int) p2.profit - (int) p1.profit);

		int i = 0;
		for (; i < topHighest; i++) {
			sb.append(products.get(i).identity + " ").append(products.get(i).name + " ")
					.append(products.get(i).profit + "\n");
		}
		for (; i < cases; i++) {
			if (products.get(i).profit == products.get(i - 1).profit) {
				sb.append(products.get(i).identity + " ").append(products.get(i).name + " ")
						.append(products.get(i).profit + "\n");
			} else
				break;
		}
		System.out.println(sb);
	}

	static class Product {
		private int identity;
		private String name;
		private long price;
		private long cost;
		private long quantity;
		private long profit;

		public Product(int identity, String name, long price, long cost, long quantity) {
			this.identity = identity;
			this.name = name;
			this.price = price;
			this.cost = cost;
			this.quantity = quantity;
			profit = (price - cost) * quantity;
		}

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