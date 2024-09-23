import java.util.Arrays;
import java.util.Scanner;

public class EIKMAX {
    

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for ( int i = 0 ; i < arr.length ; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
    
        for (int i = n - 1 ; i >= n - k  ; i-- ) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);

        // for (int i = 1 ; i <= k  ; i++ ) {
        //     System.out.print(arr[n -i ] + " ");
        // }   // scrore : 90
    }
}
