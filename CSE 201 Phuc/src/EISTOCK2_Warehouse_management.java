import java.util.*;
import java.io.*;

public class EISTOCK2_Warehouse_management {
//  
//	
//	
//	
//	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int numberOfTransactions = reader.nextInt();
		Map<Integer, Product> listOfProducts = new HashMap<>();

		for (int i = 0; i < numberOfTransactions; i++) {
			String operation = reader.next();
			int id = reader.nextInt();
			long quality = reader.nextInt();
			double price = reader.nextDouble();
			int timeOfTransation = reader.nextInt();

			Product product = listOfProducts.get(id);
			if (product == null) {
				product = new Product(id);
				listOfProducts.put(id, product);
			}

			if (operation.equals("+")) {
				product.importItem(id, quality, price, timeOfTransation);
			} else {
				if (quality <= product.totalPrducts) {
					product.exportItem(quality);
				}
			}
		}

		List<Product> products = new ArrayList<>(listOfProducts.values());
		products.sort((p1, p2) -> {
			return p1.id - p2.id;
		});
		for (Product i : products) {
			sb.append(i.id + " " + i.totalPrducts + " " + i.timeOfTransation + " \n");
		}
		System.out.println(sb);
	}

	static class Transation {
		private int id;
		private long items;
		private double cost;
		private int timeOfTransation;

		public Transation(int id, long items, double cost, int timeOfTransation) {
			this.id = id;
			this.items = items;
			this.cost = cost;
			this.timeOfTransation = timeOfTransation;
		}

	}

	static class Product {
		private int id;
		private long totalPrducts;
//		private long totalPrice;
//		private long exportPrice;
//		private double averagePriceOfProduct;
		private int timeOfTransation;
		private Queue<Transation> queue;

		public Product(int id) {
			this.id = id;
			queue = new ArrayDeque<>();
		}

		public void importItem(int id, long item, double cost, int timeOfTransation) {
			Transation product = new Transation(id, item, cost, timeOfTransation);
			queue.add(product);
			totalPrducts += item;
//			totalPrice += item * cost;
//			Transation trans = queue.peek();
//			timeOfTransation = trans.timeOfTransation;
			
		}

		public void exportItem(long item) {

			while (item > 0) {
				Transation trans = queue.peek();
//				timeOfTransation = trans.timeOfTransation;
				if (trans.items > item) {
					trans.items -= item;
					totalPrducts -= item;
					item = 0;
				} else {
					queue.poll();
					item -= trans.items;
					totalPrducts -= trans.items;
				}
			}

		}

		public int getTimeOfTransation() {
			Transation trans = queue.peek();
			timeOfTransation = trans.timeOfTransation;
			return timeOfTransation;
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