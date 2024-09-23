import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EIUGIFTS {

	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = reader.nextInt();
		int[] arrProduct = new int[n];
		for (int i = 0 ; i < n ; i++) {
			arrProduct[i] = reader.nextInt();
		}
		
		int money = reader.nextInt();
		
		Arrays.sort(arrProduct);
		
		int firstGift = 0 ;  // đánh dấu chỉ số món quà đầu tiên 
		int secondGift = n - 1 ;  // dánh dấu món quà thứ 2 bắt đầu từ phần tử cuối cùng

		int t = 0 ; // tổng giá tiền của 2 món đã chọn 
		int Difference = 0 ; 
		
		while ( firstGift < secondGift ) {
			
			if (arrProduct[firstGift] + arrProduct[secondGift] <= money ) {
				if ( arrProduct[firstGift] + arrProduct[secondGift] >= t ) {
					t = arrProduct[firstGift] + arrProduct[secondGift] ; 
					Difference = arrProduct[secondGift] - arrProduct[firstGift];
					
					if ( arrProduct[secondGift] - arrProduct[firstGift] < Difference ) {
						Difference = arrProduct[secondGift] - arrProduct[firstGift];
					}
				}
				firstGift++;
			} else {
				secondGift--;
			}
		}
		if (t != 0 ) {
			System.out.println(t + " " + Difference);
		} else {
			System.out.println("-1 -1");
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
