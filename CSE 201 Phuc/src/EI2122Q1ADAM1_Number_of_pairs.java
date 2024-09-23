import java.util.*;
import java.io.*;

public class EI2122Q1ADAM1_Number_of_pairs {

	public static void main(String[] args) {
		
		int numbers = reader.nextInt();
		int indices = reader.nextInt();
		int pair = 0;
		List<Long> listOfNumbers = new ArrayList<Long>();

		for (int i = 0; i < numbers; i++) {
			listOfNumbers.add(reader.nextLong());
		}

		for (int i = 0; i < listOfNumbers.size(); i++) {
			for (int j = listOfNumbers.size() - 1; j > i; j--) {
				long distance =  listOfNumbers.get(j) - listOfNumbers.get(i);
				if(distance == indices) {
					pair++;
				}
			}
		}
		
		System.out.println(pair);
		
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