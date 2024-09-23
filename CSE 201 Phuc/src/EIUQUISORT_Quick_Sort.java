import java.util.*;
import java.io.*;

public class EIUQUISORT_Quick_Sort {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int totalNumbers = reader.nextInt();
		int[] listOfnumbers = new int[totalNumbers];

		for (int i = 0; i < listOfnumbers.length; i++) {
			listOfnumbers[i] = reader.nextInt();
		}

		quickSort(listOfnumbers, 0, listOfnumbers.length);

		for (int i : listOfnumbers) {
			sb.append(i + "\n");
		}
		System.out.println(sb);
	}

	static void quickSort(int[] numbers, int left, int right) {
		if (left < right) {
			int middle = partition(numbers, left, right);
			quickSort(numbers, left, middle); // quickSort(arr, low, pi - 1);
			quickSort(numbers, middle + 1, right);

		}
	}

	static int partition(int[] numbers, int left, int right) {
		int pivot = numbers[left]; // int pivot = arr[high];

		int i = left; // int i = (low - 1);
		int j = left + 1; // int j = left; 

		for (; j < right; j++) {
			if (numbers[j] <= pivot) {
				swap(numbers, j, ++i);
			}
		}
		swap(numbers, left, i);
		return i;
	}
	
//	 for (int j = low; j <= high - 1; j++) {        
//         if (arr[j] < pivot) {
//             i++;
//             swap(arr, i, j);
//         }
//     }
//     swap(arr, i + 1, high);
//     return (i + 1);
// }

	static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
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