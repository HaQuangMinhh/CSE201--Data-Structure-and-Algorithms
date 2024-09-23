import java.util.LinkedHashSet;
import java.util.Scanner;

public class EIUPH011_2 {
    
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
   //     System.out.println("Users input a number in an array: ");
        int num = sc.nextInt();
        
        int[] nums = new int[num];
    //    System.out.println("So luong pt: " + nums.length);
        
        LinkedHashSet<Integer> arr = new LinkedHashSet<>();
        for ( int i = 0 ; i < nums.length ; i++ ) {
            nums[i] = sc.nextInt();
            arr.add(nums[i]);
        }

        for (int i : arr ) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}
