import java.util.*;
import java.io.*;


public class EIUPH014 {

	public static void main(String[] args) {
		int n = reader.nextInt();
		int[] arr = new int [n];
		for(int i = 0; i<arr.length; i++) {
			arr[i] =  reader.nextInt();
		}
		int count = 0;
		while (n != 0) {
			while (!isSame(arr) && n != 0) {
				int t = arr[0];
				int i = 0;
				for (; i < arr.length - 1; i++)
					arr[i] = Math.abs(arr[i] - arr[i + 1]);
				arr[i] = Math.abs(arr[i] - t);
				count++;
				if (count > 1000)
					break;
			}
			if (count > 1000)
				System.out.println(-1);
			else
				System.out.println(count);
			n = reader.nextInt();
			arr = new int [n];
			for(int i = 0; i<arr.length; i++) {
				arr[i] =  reader.nextInt();
			}
			count = 0;
		}
	}

	public static boolean isSame(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] != a[i + 1])
				return false;
		}
		return true;
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


//import java.util.Scanner;
//
//class EIUPH014 {
//	public static Scanner sc = new Scanner(System.in);
//
//	public static void main(String[] args) {
//		int n = sc.nextInt();
//		int[] arr = input(n);
//		int count = 0;
//		while (n != 0) {
//			while (!isSame(arr) && n != 0) {
//				int t = arr[0];
//				int i = 0;
//				for (; i < arr.length - 1; i++)
//					arr[i] = Math.abs(arr[i] - arr[i + 1]);
//				arr[i] = Math.abs(arr[i] - t);
//				count++;
//				if (count > 1000)
//					break;
//			}
//			if (count > 1000)
//				System.out.println(-1);
//			else
//				System.out.println(count);
//			n = sc.nextInt();
//			arr = input(n);
//			
//			count = 0;
//		}
//	}
//
//	public static boolean isSame(int[] a) {
//		for (int i = 0; i < a.length - 1; i++) {
//			if (a[i] != a[i + 1])
//				return false;
//		}
//		return true;
//	}
//
//	public static int[] input(int a) {
//		int[] d = new int[a];
//		for (int i = 0; i < d.length; i++)
//			d[i] = sc.nextInt();
//		return d;
//	}
//}
