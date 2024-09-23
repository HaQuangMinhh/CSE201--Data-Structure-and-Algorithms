import java.util.*;
import java.io.*;


public class EIDORM_Dormitory {

	public static void main(String[] args) {
		int cases = reader.nextInt();
		int count = 0;
		for(int i = 0; i< cases; i++) {
			int personNow = reader.nextInt();
			int maxPeople = reader.nextInt();
			if(maxPeople- personNow >=2 ) {
				 count++;
			}
		}
		System.out.println(count);
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
