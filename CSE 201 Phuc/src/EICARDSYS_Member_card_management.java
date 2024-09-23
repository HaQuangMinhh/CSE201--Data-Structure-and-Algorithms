import java.util.*;
import java.io.*;

public class EICARDSYS_Member_card_management {

	public static void main(String[] args) {

		Map<String, Customer> listOfCustomers = new HashMap<String, Customer>();
		int cases = reader.nextInt();
		double discountMoney = 0;
		for (int i = 0; i < cases; i++) {
			String id = reader.next();
			long price = reader.nextLong();

			Customer customer = listOfCustomers.get(id);
			if (customer == null) {
				customer = new Customer(id);
				listOfCustomers.put(id, customer);
			}
			customer.addPrice(price);
		}

		List<Customer> customers = new ArrayList<>(listOfCustomers.values());

		for (Customer i : customers) {
			discountMoney += i.discountMoney;
		}
		System.out.println((double)Math.round(discountMoney*100)/100);

	}

	static class Customer {
		private String id;
		private List<Long> priceOfProduct;
		private double totalMoney;
		private double discountMoney;

		public Customer(String id) {
			this.id = id;
			priceOfProduct = new ArrayList<Long>();
		}

		public void addPrice(long price) {
			priceOfProduct.add(price);
			
			int million = 1_000_000;
			
			if (totalMoney < 1 * million) {
				discountMoney = 0;
			} else if (1 * million <= totalMoney && totalMoney < 20 * million) {
				discountMoney += price * 0.02;
			} else if (20 * million <= totalMoney && totalMoney < 50 * million) {
				discountMoney += price * 0.03;
			} else if (50 * million <= totalMoney && totalMoney < 200 * million) {
				discountMoney += price * 0.05;
			} else {
				discountMoney += price * 0.07;
			}
			
			totalMoney += price;
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