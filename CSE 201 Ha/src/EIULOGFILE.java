import java.io.*;
import java.util.*;

public class EIULOGFILE {
	static InputReader rd = new InputReader(System.in);
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
//		int logFileNum = rd.nextInt();
//		long[] logFilesNames = new long[logFileNum];
//
//		for (int i = 0; i < logFileNum; i++) {
//			logFilesNames[i] = rd.nextLong();
//		}
//		Arrays.sort(logFilesNames);
//
//		long timeTaken = 0;
//		for (int j = 0; j < logFileNum - 1; j++) {
//			int temp = binarySearch(logFilesNames, j, logFilesNames[j] + 600001) - j;
//			if (temp + j == logFileNum - 1) {
//				timeTaken += (temp * (temp + 1)) / 2;
//				break;
//			}
//
//			timeTaken += temp;
//
//		}
//		System.out.println(timeTaken);
		
		int N = rd.nextInt();
		long[] log = new long[N];
		for (int i = 0; i < N; i++) {
			log[i] = rd.nextLong() * 2;
		}
		Arrays.sort(log);
		long result = 0;

		for (int i = 0; i < N; i++) {
			int index = ~Arrays.binarySearch(log, log[i] + 1200001);
			result += (index - 1 - i);
		}
		System.out.println(result);
	}

	public static int binarySearch(long[] logFileNames, int startIndex, long key) {
		int left = startIndex, right = logFileNames.length - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (logFileNames[middle] < key) {
				left = middle + 1;
			} else if (logFileNames[middle] > key) {
				right = middle - 1;
			} else {
				return middle;
			}
		}

		return right;
	}

	public static void caseTwo() {
		int N = rd.nextInt();
		long[] log = new long[N];
		for (int i = 0; i < N; i++) {
			log[i] = rd.nextInt() * 2;
		}
		Arrays.sort(log);
		long result = 0;

		for (int i = 0; i < N; i++) {
			int index = ~Arrays.binarySearch(log, log[i] + 1200001);
			result += (index - 1 - i);
		}
		System.out.println(result);
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
