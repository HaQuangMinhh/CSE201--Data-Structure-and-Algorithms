import java.util.*;
import java.io.*;

class EIGRADU {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        int m = reader.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int studentID = reader.nextInt();
            String studentName = reader.next();
            int numOfCourses = reader.nextInt();
            List<Integer> grades = new ArrayList<>();

            int totalCredits = 0;
            int totalPoints = 0;

            for (int j = 0; j < numOfCourses; j++) {
                int grade = reader.nextInt();
                grades.add(grade);

                if (grade >= 50) {

                    totalCredits += 4;
                    totalPoints += grade;

                }
            }
            int avg = totalPoints / (totalCredits / 4);
            if (totalCredits >= m) {
                Student student = new Student(studentID, studentName, avg);
                students.add(student);
            }
        }
        students.sort((s1, s2) -> {
            int compare = s2.avg - s1.avg;
            if (compare == 0) {
                compare = s1.studentID - s2.studentID;
            }
            return compare;
        });
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {

            sb.append(student.studentID)
                    .append(" ")
                    .append(student.studentName)
                    .append(" ")
                    .append(student.avg)
                    .append("\n");
        }
        System.out.print(sb);
    }

    static class Student {
        int studentID;
        String studentName;
        int avg;

        public Student(int studentID, String studentName, int avg) {
            this.studentID = studentID;
            this.studentName = studentName;
            this.avg = avg;

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