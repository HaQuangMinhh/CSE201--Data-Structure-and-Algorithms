import java.util.*;
import java.io.*;

public class EIULOGFILE_Log_files {

	public static void main(String[] args) {
		List <Long> listOfLogFiles = new ArrayList<Long>();
		int cases = reader.nextInt();
		
		for(int i = 0; i< cases; i++) {
			listOfLogFiles.add(reader.nextLong());
		}
		
//		Arrays.sort(listOfLogFiles);
		listOfLogFiles.sort((l1,l2) -> {
			int compare = Long.compare(l1, l2);
			return compare;
		});
		
		
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