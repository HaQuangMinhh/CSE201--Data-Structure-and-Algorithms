import java.util.Arrays;
import java.util.Scanner;

public class EIUMEDARRAY4_Kth_Smallest_Element {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();

		for (int i = 0; i < cases; i++) {
			int n = sc.nextInt();
			int a = sc.nextInt();
			int p = sc.nextInt();
			int k = sc.nextInt();
			long[] array = new long[n];
			array[0] = (a * a) % p;
			
			for (int j = 1; j < array.length; j++) {
				array[j] = (array[j - 1] * a) % p;
			}
			
			sb.append(quickSort(array, 0, array.length - 1, k) + "\n");
		}
		
		System.out.println(sb);

	}

	static long quickSort(long[] numbers, int left, int right, int k) {
//		if (left < right) {	
		int middle = (int) partition(numbers, left, right);
		if (middle == k - 1) {
			return numbers[middle];
		} else if (middle < k - 1) {
			return quickSort(numbers, middle + 1, right, k);
		} else {
			return quickSort(numbers, left, middle - 1, k);
		}
//		}
	}

	static long partition(long[] numbers, int left, int right) {
		long pivot = numbers[left];
		int i = left;
		int j = left + 1;

		for (; j < right; j++) {
			if (numbers[j] <= pivot) {
				swap(numbers, j, ++i);
			}
		}
		swap(numbers, left, i);
		return i;
	}

	static void swap(long[] numbers, int i, int j) {
		long temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
