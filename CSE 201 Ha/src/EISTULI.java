import java.io.*;
import java.util.*;

 class EISTULI {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        int k = reader.nextInt(); 

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
        List<Student> sortedStudents = new ArrayList<>(students);
        sortedStudents.sort((s1, s2) -> {
            double avg1 = s1.calculateAverage();
            double avg2 = s2.calculateAverage();

            if (Double.compare(avg2, avg1) != 0) {
                return Double.compare(avg2, avg1); 
            } else {
                return Integer.compare(students.indexOf(s1), students.indexOf(s2)); 
                                                                                    
            }
        });

        
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(k, sortedStudents.size()); i++) {
            Student student = sortedStudents.get(i);
            double avg = Math.round(student.calculateAverage());
            sb.append(student.id).append(" ")
                    .append(student.name).append(" ")
                    .append(Math.round(avg)).append(" ")
                    .append(student.getNumCredits()).append("\n");
        }

        System.out.println(sb.toString());
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

        public int getNumCredits() {
            int numCredits = 0;
            for (int score : scores) {
                if (score >= 50) {
                    numCredits++;
                }
            }
            return numCredits * 4;
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