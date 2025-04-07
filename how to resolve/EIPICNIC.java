import java.util.Scanner;

public class EIPICNIC {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int[] groupCount = new int[5];

        for (int i = 0; i < num ; i++) {
            int size = sc.nextInt();
            groupCount[size]++;
        }

        int totalCars = 0 ; 

        // Group 4 ng 
        totalCars += groupCount[4] ; 

        // Group 3 ng 
        totalCars += groupCount[3] ; 
        groupCount[1] = Math.max(0, groupCount[1] - groupCount[3]);

        // Group 2 ng
        totalCars += groupCount[2] / 2 ;
        groupCount[2] %= 2 ; 

        // Group 1 ng 
        if ( groupCount[2] == 1 ) {
            totalCars += 1 ; 
            groupCount[1] = Math.max(0, groupCount[1] - 2 );
        }

        // Group các nhóm 1 ng còn lại 
        totalCars += (groupCount[1] + 3) / 4;

        System.out.println(totalCars);
    }
}
