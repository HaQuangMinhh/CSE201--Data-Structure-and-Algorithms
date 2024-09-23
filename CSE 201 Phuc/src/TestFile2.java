
import java.io.*;
import java.util.*;

public class TestFile2 {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int numbers = reader.nextInt();
		HashMap<Integer, Product> products = new HashMap<>();
		for (int i = 0; i < numbers; i++) {
			String c = reader.next();
			int code = reader.nextInt();
			long quanity = reader.nextLong();
			long price = reader.nextLong();
			long time = reader.nextLong();
			if (c.equals("+")) {
				Product p = new Product(code);
				products.put(code, products.getOrDefault(code, p));
				products.get(code).addItems(quanity, price, time);
			} else {
				if (products.get(code) != null) {
					products.get(code).export(quanity, price);
				}
			}
		}
		ArrayList<Product> list = new ArrayList<>(products.values());
		list.sort((o1, o2) -> {
			int compare = Integer.compare(o1.getCode(), o2.getCode());
			return compare;
		});
		for (Product p : list) {
			if (p.getTotalItems() > 0) {
				Import i = p.calculateAve();
				sb.append(p.getCode() + " " + i.getItems() + " " + i.getPrice() + " " + i.getTime());
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	static class Product {
		private int code;
		Queue<Import> trans;
		private long totalItems;

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public long getTotalItems() {
			return totalItems;
		}

		public void setTotalItems(long totalItems) {
			this.totalItems = totalItems;
		}

		public Product(int code) {
			this.code = code;
			trans = new ArrayDeque<>();
		}

		public void addItems(long quanity, long price, long time) {
			Import i = new Import(quanity, price, time);
			trans.add(i);
			totalItems += quanity;
		}

		public void export(long quanity, long price) {
			if (quanity <= totalItems) {
				while (quanity > 0) {
					if (quanity >= trans.peek().getItems()) {
						totalItems -= trans.peek().getItems();
						quanity -= trans.poll().getItems();
					} else {
						totalItems -= quanity;
						trans.peek().setItems(trans.peek().getItems() - quanity);
						break;
					}
				}
			}
		}

		public Import calculateAve() {
			Import i = new Import(totalItems, totalItems, totalItems);
			long price = 0;
			i.setTime(trans.peek().getTime());
			for (int j = 0; j < trans.size(); j++) {
				price += trans.peek().getItems() * trans.poll().getPrice();
				j--;
			}
			i.setItems(totalItems);
			i.setPrice(price / totalItems);
			return i;
		}

	}

	static class Import {
		private long items;
		private long price;
		private long time;



		public Import(long items, long price, long time) {
			this.items = items;
			this.price = price;
			this.time = time;
		}

		public long getItems() {
			return items;
		}

		public void setItems(long items) {
			this.items = items;
		}

		public long getPrice() {
			return price;
		}

		public void setPrice(long price) {
			this.price = price;
		}
public long getTime() {
			return time;
		}

		public void setTime(long time) {
			this.time = time;
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