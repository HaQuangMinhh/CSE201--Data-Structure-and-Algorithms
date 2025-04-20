import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EIUSLS {

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        
        int testcases = sc.nextInt();

        for ( int i = 0 ; i < testcases ; i++ ) {
            String name = sc.next(); 
            int codeSub = sc.nextInt();
            
            Student person = new Student(name);

            for ( int k = 0 ; k < codeSub ; k++ ) {
                person.addScore(sc.nextDouble());
            }
            students.add(person);
        }

        students.sort( (s1, s2) -> {
            int compare = Double.compare(s2.avg, s1.avg);
            return compare;
        }); 

        int i = 0 ;
        int k = 0 ; 

        for ( ; i < 2 && k < testcases ; i++, k++ ) {
            sb.append(students.get(i).name).append("\n");
        }

        System.out.println(sb);

    }

    static class Student {
        private String name ; 
        private int order ; // thứ tự nhập 

        private double totalGrade = 0 ; 
        private int count ;
        private double avg ; 

        public Student ( String name ) {
            this.name = name ; 
        }
        
        public void addScore ( double score ) {
            totalGrade += score ;
            count++; 
            avg = totalGrade / count ; 
        }
    }

}
