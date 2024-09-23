import java.util.Scanner;

 class EIUSELECTION_SORT {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String dataType = sc.next();
    
        if (dataType.equals("double")) {
            Double[] array = new Double[N];
            for (int i = 0; i < N; i++) {
                array[i] = sc.nextDouble();
            }
            selectionSort(array);
    
            for (Double num : array) {
                System.out.print(num + " ");
            }
        } else if (dataType.equals("float")) {
            Float[] array = new Float[N];
            for (int i = 0; i < N; i++) {
                array[i] = sc.nextFloat();
            }
            selectionSort(array);
            for (Float num : array) {
                System.out.print(num + " ");
            }
        } else if (dataType.equals("long")) {
            Long[] array = new Long[N];
            for (int i = 0; i < N; i++) {
                array[i] = sc.nextLong();
            }
            selectionSort(array);
            for (Long num : array) {
                System.out.print(num + " ");
            }
        } else if (dataType.equals("int")) {
            Integer[] array = new Integer[N];
            for (int i = 0; i < N; i++) {
                array[i] = sc.nextInt();
            }
            selectionSort(array);
            for (Integer num : array) {
                System.out.print(num + " ");
            }
        }
    }

    static <T extends Number & Comparable<T>> void selectionSort(T[] array) {
        // Your code here
        // Compare t[i] and T[j]: t[i].compareTo(T[j])
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (array[j].compareTo(array[min_idx]) < 0) {
                    min_idx = j;
                }
            T temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }

    }
}