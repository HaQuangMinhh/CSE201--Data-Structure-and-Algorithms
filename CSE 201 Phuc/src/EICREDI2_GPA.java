import java.util.*;
import java.io.*;

public class EICREDI2_GPA {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		int caes = reader.nextInt();
		for (int i = 0; i < caes; i++) {
			int count = 0;
			double avg = 0;
			String name = reader.next();
			sb.append(name + " ");
			int totalOfSubject = reader.nextInt();
			for (int j = 0; j < totalOfSubject; j++) {
				double grade = reader.nextDouble();
				if (grade >= 50) {
					count++;
					avg += grade;
					sb.append((int) grade + " ");
				}
			}
			if (count == 0) {
				sb.append(0 + "\n");
			} else
				sb.append((int) avg / count + "\n");
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