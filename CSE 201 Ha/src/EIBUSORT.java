import java.util.Scanner;

public class EIBUSORT {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String dataType = sc.next();

        if (dataType.equals("double")) {
            Double[] array = new Double[N];
            for (int i = 0; i < N; i++) {
                array[i] = sc.nextDouble();
            }

            bubbleSort(array);

            for (Double num : array) {
                System.out.print(num + " ");
            }
        } else if (dataType.equals("int")) {
            Integer[] array = new Integer[N];
            for (int i = 0; i < N; i++) {
                array[i] = sc.nextInt();
            }

            bubbleSort(array);

            for (Integer num : array) {
                System.out.print(num + " ");
            }
        } else if (dataType.equals("long")) {
            Long[] array = new Long[N];
            for (int i = 0; i < N; i++) {
                array[i] = sc.nextLong();
            }

            bubbleSort(array);

            for (Long num : array) {
                System.out.print(num + " ");
            }
        } else if (dataType.equals("float")) {
            Float[] array = new Float[N];
            for (int i = 0; i < N; i++) {
                array[i] = sc.nextFloat();
            }

            bubbleSort(array);

            for (Float num : array) {
                System.out.print(num + " ");
            }
        }
    }

    static <T extends Number & Comparable<T>> void bubbleSort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}