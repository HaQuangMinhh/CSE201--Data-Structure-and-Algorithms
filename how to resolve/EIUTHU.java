import java.util.Scanner;

public class EIUTHU {


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String part1 = sc.next();
        String part2 = sc.next(); 

        // Tìm phần cuối của part 1 and đầu part 2 
        int maxOverLap = 0 ;    // kí tự bị trùng

        for ( int i = 1 ; i <= part1.length() ; i++ ) {
            String suffix = part1.substring( part1.length() - i); // kí tự cuối 

            if ( part2.startsWith(suffix) ) {
                maxOverLap = i ; 
            }
        }

        int result = part1.length() + part2.length() - maxOverLap ; 

        System.out.println(result);


        sc.close();
    }
}
