import java.util.*;
import java.io.*;

public class EIUPREIU_EIU {

	public static void main(String[] args) {

		int height = reader.nextInt();
		int wide = 6 + height;
		String dash = "_";
		String space = " ";

		if (height > 2) {
			for (int i = 1; i < height / 2; i++) {
				dash += "_";
				space += " ";
			}
		}
		
		for (int j = 0; j < wide; j++) {
			if (j > 0 && j <= height / 2) {
				System.out.print("_");
			} else {
				System.out.print(" ");
			}
		}
		
		System.out.println();
		
		for (int k = 1; k < height / 2; k++) {
			System.out.println("|" + space + " | |" + space + "|");
		}
		
		System.out.println("|" + dash + " | |" + space + "|");

		for (int l = 1; l < height / 2; l++) {
			System.out.print("|" + space + " | |" + space + "|");
		}
		
		System.out.print("|" + dash + " | |" + dash + "|");

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
