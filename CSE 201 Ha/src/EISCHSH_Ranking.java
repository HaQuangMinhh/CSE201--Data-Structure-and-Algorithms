import java.io.*;
import java.util.*;

 class EISCHSH_Ranking {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt(); // Number of students
        int k = reader.nextInt(); // Number of scholarships

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int id = reader.nextInt();
            String name = reader.next();
            int numCourses = reader.nextInt();
            int[] scores = new int[numCourses];
            for (int j = 0; j < numCourses; j++) {
                scores[j] = reader.nextInt();
            }
            students.add(new Student(id, name, numCourses, scores));
        }
      
        students.sort((s1, s2) -> {
            double avg1 = s1.calculateAverage();
            double avg2 = s2.calculateAverage();
            if (avg1 != avg2) {
                return Double.compare(avg2, avg1); 
            } else {
                return Integer.compare(s1.id, s2.id); 
                                                     
            }
        });

        int rank = 1;
        double prevAvg = -1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            Student student = students.get(i);

            double avg = student.calculateAverage();

            if (avg != prevAvg) {
                prevAvg = avg;
                sb.append(rank).append(" ").append(student.id).append(" ").append(student.name).append(" ").append(Math.round(avg)).append("\n");
               
            } else {
                sb.append(rank-1).append(" ").append(student.id).append(" ").append(student.name).append(" ").append(Math.round(avg)).append("\n");
            }
            rank++;

        }
        System.out.print(sb.toString());
    }

    static class Student {
        int id;
        String name;
        int numCourses;
        int[] scores;

        public Student(int id, String name, int numCourses, int[] scores) {
            this.id = id;
            this.name = name;
            this.numCourses = numCourses;
            this.scores = scores;
        }

        public double calculateAverage() {
            int totalScore = 0;
            int numPassedCourses = 0;

            for (int score : scores) {
                if (score >= 50) {
                    totalScore += score;
                    numPassedCourses++;
                }
            }

            return (double) totalScore / numPassedCourses;
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
