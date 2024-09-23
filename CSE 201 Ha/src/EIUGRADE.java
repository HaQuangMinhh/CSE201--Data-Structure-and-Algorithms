import java.util.*;

import java.io.*;

class EIUGRADE {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) throws IOException {
        int n = reader.nextInt();

        Map<Integer, Student> students = new HashMap<Integer, Student>();

        for (int i = 0; i < n; i++) {
            int studentId = reader.nextInt();
            int courseId = reader.nextInt();
            double score = reader.nextDouble();
            if (!students.containsKey(studentId)) {
                students.put(studentId, new Student(studentId, score));
            } else {
                students.get(studentId).addScore(score);
            }
        }
        List<Student> result = new ArrayList<>(students.values());
        result.sort((s1, s2) -> {
            int compare = Double.compare(s2.Average(), s1.Average());
            if (compare == 0) {
                compare = (s1.getId() - s2.getId());
            }
            return compare;
        });
        StringBuilder sb = new StringBuilder();
        for (Student student : result) {
            sb.append(student.getId()).append(" ").append(String.format("%.3f", student.Average())).append("\n");
        }
        System.out.print(sb.toString());
    }

    static class Student {
        int id;
        double totalScore;
        long count;

        public Student(int id, double score) {
            this.id = id;
            this.totalScore = score;
            this.count = 1;
            Average();
        }

        private void addScore(double score) {
            totalScore += score;
            count++;
        }

        double Average() {
            return this.totalScore / (double) this.count;
        }

        public int getId() {
            return id;
        }

    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}