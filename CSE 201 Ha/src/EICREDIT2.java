import java.util.*;
import java.io.*;

 class EICREDIT2 {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int testCase = reader.nextInt();
        for (int i = 0; i < testCase; i++) {
            String name = reader.next();
            int numCourses = reader.nextInt();
            int passedCourses = 0;
            int totalScore = 0;

            StringBuilder sb = new StringBuilder();
            sb.append(name).append(" ");

            for (int j = 0; j < numCourses; j++) {
                int score = reader.nextInt();
                if (score >= 50) {
                    passedCourses++;
                    totalScore += score;
                    sb.append(score).append(" ");
                }
            }

            if (passedCourses > 0) {
                int averageScore = totalScore / passedCourses;
                sb.append(averageScore);
            } else {
                sb.append("0");
            }

            System.out.println(sb);
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