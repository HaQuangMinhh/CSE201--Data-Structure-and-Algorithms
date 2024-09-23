

import java.io.*;
import java.util.*;
import java.util.concurrent.DelayQueue;

public class EISTOCK2 {
	static InputReader rd = new InputReader(System.in);
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		int transactions = rd.nextInt();

		HashMap<Integer, Products> listProducts = new HashMap<Integer, Products>();

		for (int i = 0; i < transactions; i++) {
			String status = rd.next();
			int code = rd.nextInt();
			long quantity = rd.nextLong();
			long price = rd.nextLong();
			int time = rd.nextInt();

			if (!listProducts.containsKey(code)) {
				listProducts.put(code, new Products(code));
			}
			Products pr = listProducts.get(code);

			if (status.equals("+")) {
				Imports im = new Imports(quantity, time, price);
				pr.importValues(im);
			} else {
				if (pr.quantity >= quantity) {
					pr.shippedProduct(quantity, price);
				}
			} 

		}

		ArrayList<Products> sortedProducts = new ArrayList<Products>(listProducts.values());

		sortedProducts.sort((p1, p2) -> {
			return p1.code - p2.code;
		});

		for (Products pr : sortedProducts) {
			if (pr.quantity != 0) {
				pr.calculateAvg();
				sb.append(pr.code).append(" ").append(pr.quantity).append(" ").append((long) pr.average).append(" ")
						.append(pr.oldest).append("\n");
			}
		}
		System.out.println(sb);
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

class Products {
	int code;
	long quantity = 0;
	double average;
	int oldest;

	Queue<Imports> listImport = new ArrayDeque<>();

	public Products(int code) {
		this.code = code;
	}

	public void shippedProduct(long exportQuantity, long price) {
		long remain = exportQuantity;
		this.quantity -= exportQuantity;

		while (remain > 0 && !this.listImport.isEmpty()) {
			Imports pr = this.listImport.peek();
			
			remain = exportQuantity - pr.quantity;
			if (remain >= 0) {
				exportQuantity -= pr.quantity;
				this.listImport.poll();
			} else if (remain < 0) {
				pr.quantity = -remain;
			}
		}

	}

	public void calculateAvg() {
		long remainQuantiy = 0;
		//Find the oldest remain
		if (!listImport.isEmpty())
			this.oldest = listImport.peek().time;

		//average
		while (!listImport.isEmpty()) {
			remainQuantiy += listImport.peek().quantity;
			this.average += listImport.peek().quantity * listImport.poll().price;
		}
		if (remainQuantiy != 0)
			this.average /= remainQuantiy;

	}

	public void importValues(Imports pr) {
		listImport.add(pr);
		this.quantity += pr.quantity;
	}
}

class Imports {
	public long quantity;
	public int time;
	public long price;

	public Imports(long quantity, int time, long price) {
		this.quantity = quantity;
		this.time = time;
		this.price = price;
	}

}