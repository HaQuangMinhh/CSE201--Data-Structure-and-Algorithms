import java.util.*;
import java.io.*;

public class EIUBUSOR_BubbleSort {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String dataType = sc.next();
		String in = "int";
		String doub = "double";
		String lo = "long";
		String flo = "float";

		if (dataType.compareTo(in)== 0) {
			Integer[] array = new Integer[N];
			for (int i = 0; i < N; i++) {
				array[i] = sc.nextInt();
			}
			bubbleSort(array);
			for(Integer i : array) {
				sb.append(i + " ");
			}
		}
		if (dataType.compareTo(doub) == 0 ) {
			Double[] array = new Double[N];
			for (int i = 0; i < N; i++) {
				array[i] = sc.nextDouble();
			}
			bubbleSort(array);
			for(double i : array) {
				sb.append(i + " ");
			}
		}

		if (dataType.compareTo(lo) == 0 ) {
			Long[] array = new Long[N];
			for (int i = 0; i < N; i++) {
				array[i] = sc.nextLong();
			}
			bubbleSort(array);
			for(Long i : array) {
				sb.append(i + " ");
			}
		}

		if (dataType.compareTo(flo) ==0 ) {
			Float[] array = new Float[N];
			for (int i = 0; i < N; i++) {
				array[i] = sc.nextFloat();
			}
			bubbleSort(array);
			for(Float i : array) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb);
		
		// Your code here
	}

	static <T extends Number & Comparable<T>> void bubbleSort(T[] array) {
		T temp;
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < (array.length - i); j++) {
				if ((array[j - 1]).compareTo(array[j]) == 1) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}

			// Your code here

			// Compare t[i] and T[j]: t[i].compareTo(T[j])

		}
	}
}
