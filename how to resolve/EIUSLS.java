package baitap;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EIUSLS {
    
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        int n = reader.nextInt(); // số lượng sinh viên 
        
        List<Student> students = new ArrayList<>(); // Create a list of Array to hold Student Objects

        for ( int i = 0 ; i < n ; i++) {
            String name = reader.next();
            int NumCourses = reader.nextInt(); // number of courses
            int TotalScore = 0 ;

            for (int j = 0 ; j < NumCourses ; j++ ) {
                TotalScore += reader.nextInt(); // sum up the scores of all courses 
            }
            double averageScore = (double) TotalScore / NumCourses ; // 
            students.add(new Student(name, averageScore)); // add to the students 

        }
        students.sort((a,b) -> Double.compare(b.getAverageScore(), a.getAverageScore() )); // Sorted the list of students 

        System.out.println(students.get(0).getName() ); //  Print out the student with the highest scores   

        if (students.size() > 1 ) {   // giải quyết nhiều students có the same second-highest score. 
            double secondHighestScore = students.get(1).getAverageScore();
            
            int i = 1;          
            while ( i < students.size() && students.get(i).getAverageScore() == secondHighestScore) {
                i++;
            }

            for (int j = 1 ; j < i ; j++) {
                System.out.println(students.get(j).getName()   );
                break;
            }
        }
        
        
    }
    static class Student {
        private String name ; 
        private double averageScore ; 
        
        public Student (String name , double averageScore) {
            this.name = name ; 
            this.averageScore = averageScore ; 
        }

        public String getName() {
            return name;
        }

        public double getAverageScore() {
            return averageScore;
        }
    }


    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
