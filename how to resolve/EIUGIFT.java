import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EIUGIFT {

	
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = reader.nextInt();
		int money = reader.nextInt();
		
		int[] arrProduct = new int[n];
		for (int i = 0 ; i < n ; i++ ) {
			arrProduct[i] = reader.nextInt();
		}
			
		Arrays.sort(arrProduct);
		
		int maxMoney = 0 ;
		int Difference = money ; 
		for (int i = 0 , j = arrProduct.length - 1 ; i < arrProduct.length && j > 1 ; i++, j--) {
			int sumMoney = arrProduct[i] + arrProduct[j];
			int gap = Math.abs(arrProduct[i] - arrProduct[j]);
			
			if (sumMoney <= money) {
				if (sumMoney >= maxMoney) {
					maxMoney = sumMoney ; 
					Difference = gap ;
				}	
			}
			
			if (sumMoney > money ) {
				i--;
			} else {
				j++;
			}	
		}
		if (maxMoney == 0 && Difference == money) {
			System.out.println(-1 + " " + -1);
		} else 
			System.out.println(maxMoney + " " + Difference);
		
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
