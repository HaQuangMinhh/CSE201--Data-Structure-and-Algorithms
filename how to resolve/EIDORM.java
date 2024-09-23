import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EIDORM {

	static InputReader reader = new InputReader(System.in) ; 
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = reader.nextInt();
		int count = 0 ; 
		
		for (int i = 0 ; i < n ; i++) {
			int pi = reader.nextInt(); // hiện tại đang có người ở 
			int qi = reader.nextInt(); // chứa tối đa người 
		
			if ( qi - pi >= 2 ) {
				count++;
				
			}
		}
		System.out.println(count);
		
		
		
		
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
