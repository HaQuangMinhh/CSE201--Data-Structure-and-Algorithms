import java.util.LinkedList;
import java.util.Scanner;

public class EIUPH011 {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        // First Occurrence
        // way to resolve : Dùng Array sau đó compare or dùng Hasmap

        int num = sc.nextInt();
     //   int[] nums = new int[num];
     //   System.out.println("So luong pt: " + nums.length);

        // Use LinkedList
        LinkedList <Integer> listNum = new LinkedList<>();
        for ( int i = 0 ; i < num ; i++ ) {
            int nums = sc.nextInt();

            if (!listNum.contains(nums)) {
                listNum.add(nums);
            }
        }
        
        for ( int Ele : listNum) {
            sb.append( Ele + " ");
        }
        // Show ra 
        System.out.println(sb);
    }    
}