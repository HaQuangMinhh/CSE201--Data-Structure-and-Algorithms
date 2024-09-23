import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class EIHPROFIT {

	static StringBuilder sb = new StringBuilder();
	static InputReader reader = new InputReader(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = reader.nextInt();
		int m = reader.nextInt();
		Map<Long, Product> map = new LinkedHashMap<>();
		
		for (int i = 0 ; i < n ; i++) {
			long id = reader.nextLong();
			String name = reader.next();
			
			Product product = map.get(id); // tìm kiếm và tạo mới san pham 
			if (product == null) {
				product = new Product(id , name);
				map.put(id, product);
			}	
			
			long price = reader.nextLong();
			long cost = reader.nextLong();
			long quantity = reader.nextLong();
			
			product.profit = (price - cost) * quantity ; 
		}
		
		List<Product> products = new ArrayList<>(map.values());
		
		products.sort( (s1,s2) -> {
			long avgCompare = Long.compare(s2.profit, s1.profit) ;
			if (avgCompare == 0) {
				return Long.compare(s1.id, s2.id);
			}
			return Long.compare( s2.profit , s1.profit);
		});
		for (int i = 0 ; i < m ; i++) {
			 sb.append(products.get(i).id)
			 .append(" ")
			 .append(products.get(i).name)
			 .append(" ")
			 .append(products.get(i).profit)
			 .append("\n");
		}
		
		for (int i = m ; i < n ; i++) {
			if (products.get(i).profit == products.get(i-1).profit ) {
				sb.append(products.get(i).id)
				.append(" ")
				.append(products.get(i).name)
				.append(" ")
				.append(products.get(i).profit )
				.append("\n");
			} else {
				break ; 
			}
			
		}
		System.out.println(sb);
		
			
		
	}
	
	static class Product {
		public Product(long id, String name) {
			super();
			this.id = id;
			this.name = name;
			
		}
		long id ; 
		String name ; 
		long profit ; 
		
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
