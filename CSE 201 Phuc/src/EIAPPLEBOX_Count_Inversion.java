
import java.util.Scanner;

public class EIAPPLEBOX_Count_Inversion {

	public static void main(String[] args) {
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
				array[j] = (array[j - 1] * a) %p;
			}
		}

	}
	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {

			int mid = (left + right) / 2;

			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);

			merge(arr, left, mid, right);
		}
	}

	public static void merge(int[] arr, int left, int middle, int right) {
		
		int length = right - left + 1;
		int[] temp = new int[length];
		int i = left, j = middle + 1, k = 0;

		while (i <= middle && j <= right) {
			if (arr[i] <= arr[j])
				temp[k++] = arr[i++];
			else
				temp[k++] = arr[j++];
				
		}
		while (i <= middle) {
			temp[k++] = arr[i++];
		}
		while (j <= right) {
			temp[k++] = arr[j++];
		}
		for (int n = 0; n < length; ++n) {
			arr[left + n] = temp[n];
		}

	}
}