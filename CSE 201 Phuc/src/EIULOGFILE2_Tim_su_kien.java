import java.util.*;
import java.io.*;

public class EIULOGFILE2_Tim_su_kien {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		int n = reader.nextInt();
		int m = reader.nextInt();
		long[] arr = new long[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = reader.nextLong();
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < m; i++) {
			long num = reader.nextLong();
			int index = Arrays.binarySearch(arr, num);

			if (index < 0) {
				index = ~index;
			}
			
			if(index >= n) {
				sb.append(-1 + " "); 
			} else {
				sb.append(arr[index] + " ");
			}
			
		}
		System.out.println(sb);
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