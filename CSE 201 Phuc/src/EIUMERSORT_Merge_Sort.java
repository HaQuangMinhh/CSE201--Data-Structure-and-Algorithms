import java.util.Scanner;
// do again
public class EIUMERSORT_Merge_Sort {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int totalNum = sc.nextInt();

		int[] listOfNum = new int[totalNum];

		for (int i = 0; i < listOfNum.length; i++) {
			listOfNum[i] = sc.nextInt();
		}

		mergeSort(listOfNum, 0, listOfNum.length - 1);

		for (int i : listOfNum) {
			sb.append(i + "\n");
		}
		System.out.println(sb);
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
