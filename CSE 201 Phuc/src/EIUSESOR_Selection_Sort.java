
import java.util.Scanner;

public class EIUSESOR_Selection_Sort {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String dataType = sc.next();
		String in = "int";
		String doub = "double";
		String lo = "long";
		String flo = "float";

		if (dataType.compareTo(in) == 0) {
			Integer[] array = new Integer[N];
			for (int i = 0; i < N; i++) {
				array[i] = sc.nextInt();
			}
			selectionSort(array);
			for (Integer i : array) {
				sb.append(i + " ");
			}
		}
		
		if (dataType.compareTo(doub) == 0) {
			Double[] array = new Double[N];
			for (int i = 0; i < N; i++) {
				array[i] = sc.nextDouble();
			}
			selectionSort(array);
			for (double i : array) {
				sb.append(i + " ");
			}
		}

		if (dataType.compareTo(lo) == 0) {
			Long[] array = new Long[N];
			for (int i = 0; i < N; i++) {
				array[i] = sc.nextLong();
			}
			selectionSort(array);
			for (Long i : array) {
				sb.append(i + " ");
			}
		}

		if (dataType.compareTo(flo) == 0) {
			Float[] array = new Float[N];
			for (int i = 0; i < N; i++) {
				array[i] = sc.nextFloat();
			}
			selectionSort(array);
			for (Float i : array) {
				sb.append(i + " ");
			}
		}
		
		System.out.println(sb);

		// Your code here
	}

	static <T extends Number & Comparable<T>> void selectionSort(T[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[minIndex].compareTo(array[j]) == 1) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				T temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}

		// Your code here
		// Compare t[i] and T[j]: t[i].compareTo(T[j])
	}
}
