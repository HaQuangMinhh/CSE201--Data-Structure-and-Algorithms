import java.util.*;
import java.io.*;

public class EISTOCK_StockManagement {
// có thể nâng lên thành giá trung bình
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int numberOfTransactions = reader.nextInt();
		Map<Integer, Product> listOfProducts = new HashMap<>();

		for (int i = 0; i < numberOfTransactions; i++) {
			String operation = reader.next();
			int id = reader.nextInt();
			long quality = reader.nextInt();
			long price = reader.nextLong();

			Product product = listOfProducts.get(id);
			if (product == null) {
				product = new Product(id);
				listOfProducts.put(id, product);
			}
			if (operation.equals("+")) {
				product.totalPrducts += quality;
				product.importPrice += quality * price;
			} else {
				if (quality <= product.totalPrducts) {
					product.totalPrducts -= quality;
					product.exportPrice += quality * price;
				}
			}
		}

		List<Product> products = new ArrayList<>(listOfProducts.values());
		products.sort((p1, p2) -> {
			return p1.id - p2.id;
		});
		for (Product i : products) {
			if (i.importPrice != 0 || i.exportPrice != 0) {
				sb.append(i.id + " " + i.importPrice + " " + i.exportPrice + " \n");
			}
			

		}
		System.out.println(sb);
	}

	static class Product {
		private int id;
		private long totalPrducts;
		private long importPrice;
		private long exportPrice;

		public Product(int id) {
			this.id = id;
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
