
import java.util.*;
import java.io.*;

 class EIUSLS {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt(); 

        
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = reader.next();
            int numCourses = reader.nextInt();
            int[] scores = new int[numCourses];
            int totalScore = 0; 
            for (int j = 0; j < numCourses; j++) {
                scores[j] = reader.nextInt();
                totalScore += scores[j];
            }
            double averageScore = (double) totalScore / numCourses; 
            students.add(new Student(name, averageScore));
        }

       
        students.sort((a, b) -> Double.compare(b.getAverageScore(), a.getAverageScore()));
       
        System.out.println(students.get(0).getName() );

      
        if (students.size() > 1) {
            double secondHighestScore = students.get(1).getAverageScore();
            int i = 1;
            while (i < students.size() && students.get(i).getAverageScore() == secondHighestScore) {
                i++;
            }
            for (int j = 1; j < i; j++) {
                System.out.println(students.get(j).getName() );
                break;
            }
        }
    }

    static class Student {
        private String name;
        private double averageScore;

        public Student(String name, double averageScore) {
            this.name = name;
            this.averageScore = averageScore;
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
