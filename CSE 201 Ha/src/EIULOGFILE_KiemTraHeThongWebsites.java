
import java.util.*;
import java.io.*;

public class EIULOGFILE_KiemTraHeThongWebsites {
    static InputReader reader = new InputReader(System.in);
	
	public static void main(String[] args) {
		int n = reader.nextInt();
        long[] logFiles = new long[n];
        for (int i = 0; i < n; i++) {
            logFiles[i] = reader.nextLong();
        }

        Arrays.sort(logFiles);

        long count = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
			// nếu j> n tức là nó đã rà hết các phần tử trong mảng
            while (j < n && logFiles[j] - logFiles[i] <= 600000) {
                j++;
            }
            count += j - i - 1;
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