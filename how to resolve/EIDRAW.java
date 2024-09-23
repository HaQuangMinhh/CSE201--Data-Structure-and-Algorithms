import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EIDRAW {

	
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int h = reader.nextInt();
		String space = "";
		for ( int k = 0 ; k < h - 1 ; k++ ) { // tránh thêm dấu cách cuối chuỗi space 
			space += "  ";
		} 
		String spaceFirst = "";
		for (int i = 0 ; i < h ; i++) {
			int n = 2 ;
			while ( n > 0 ) {
				sb.append(spaceFirst).append("\\").append(space).append("/").append(spaceFirst);
				n--;
			}
			sb.append("\n");
			spaceFirst += " ";
			if (space.length() > 2 ) {
				space = space.replaceFirst("  ", ""); // tạo rỗng trong W
			} else {
				space = "";
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
