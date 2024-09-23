import java.util.*;
import java.io.*;

public class EIDRAW_Letter_W {

	public static void main(String[] args) {

		
		int n = reader.nextInt();
		String space = "";
		String outSide = "";
		String inSide= "";
		for (int i = 0; i < (n * 4 - 4) / 2; i++) {
			space += " ";
		}
		for (int i = 0; i < n; i++) {
			System.out.println(outSide + "\\" + space + "/" + inSide + "\\" + space + "/" + outSide);
			outSide += " ";
			inSide += "  ";
			if (space.length() > 0) {
				space = space.substring(0, space.length() - 2);
			}

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
