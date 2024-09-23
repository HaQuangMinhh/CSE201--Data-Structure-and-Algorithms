package week4;

import java.io.*;
import java.util.*;;

class EIHPROFIT_TheHighestProfitableProduct {

	public static void main(String[] args) {
		int numberProducts = ni();
		int topK = ni();

		List<Product> products = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numberProducts; i++) {
			int id = ni();
			String name = ns();

			Product product = new Product(id, name);

			double price = nd();
			double cost = nd();
			int quantity = ni();

			product.calProfit(price, cost, quantity);
			products.add(product);
		}

		products.sort((p1, p2) -> {
			var compare = Double.compare(p2.totalProfit, p1.totalProfit);
			if (compare == 0) {
				compare = Integer.compare(p1.id, p2.id);
			}
			return compare;
		});

		if (numberProducts > topK) {
			for (int i = 0; i < topK; i++) {
				sb.append(products.get(i).toString()).append("\n");
				while (products.get(i).totalProfit == products.get(i + 1).totalProfit) {
					sb.append(products.get(i + 1).toString()).append("\n");
					i++;
				}
			}

		} else {
			for (Product product : products.subList(0, topK)) {
				sb.append(product.toString()).append("\n");
			}
		}
		System.out.println(sb);
	}

	static class Product {
		private int id;
		private String name;
		private double totalPrice;
		private double totalCost;
		private double totalProfit;

		public Product(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		public void calProfit(double price, double cost, int quantity) {
			totalPrice = price * quantity;
			totalCost = cost * quantity;
			totalProfit = totalPrice - totalCost;
		}

		@Override
		public String toString() {
			return id + " " + name + " " + Math.round(totalProfit);
		}

	}

	static InputStream is = System.in;
	static byte[] inbuf = new byte[1 << 24];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static double nd() {
		return Double.parseDouble(ns());
	}

	static char nc() {
		return (char) skip();
	}

	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
}
