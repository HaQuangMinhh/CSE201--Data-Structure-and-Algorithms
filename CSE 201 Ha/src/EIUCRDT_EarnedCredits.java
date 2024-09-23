import java.util.*;
import java.io.*;

public class EIUCRDT_EarnedCredits {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // Consume the newline character after reading N

        // Initialize variables to store total credits and course information
        int totalCredits = 0;
        Map<String, Integer> courseMap = new HashMap<>();

        // Read course information
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            courseMap.put(tokens[0], Integer.parseInt(tokens[1]));
        }

        // Read grades and calculate total credits
        for (int i = 0; i < N; i++) {
            int grade = sc.nextInt();
            String courseID = sc.next();

            // Check if the grade is greater than or equal to 50
            if (grade >= 50 && courseMap.containsKey(courseID)) {
                totalCredits += courseMap.get(courseID);
            }
        }

        sb.append(totalCredits).append("\n");
        System.out.print(sb.toString());
    }

}