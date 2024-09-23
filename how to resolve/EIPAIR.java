import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class EIPAIR {

	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int testcases = reader.nextInt();

		for (int t = 0 ; t < testcases ; t++) {
			int n = reader.nextInt(); // n is số lượng món quà
			int[] prices = new int[n]; // đọc giá của món quà và lưu 
			
			for (int i = 0 ; i < n ; i++) {
				prices[i] = reader.nextInt();
			}
			
			HashMap<Integer, Integer> priceCount = new HashMap<>();
			
			long pairs = 0 ; // đếm số cặp món quà có cùng giá
			
			for (int price : prices) { // Count the occurrences of each price
				priceCount.put(price, priceCount.getOrDefault(price, 0) + 1 );
			}
			
			// Calculate the number of pairs 
			for (int count : priceCount.values()) {
				pairs += (long) count*(count - 1) / 2; //c công thức số lần xuất hiện của mỗi giá
			}
			System.out.println(pairs);
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
