import java.util.*;
import java.io.*;

public class EICREDIT {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int testCase = reader.nextInt();
        for (int i = 0; i < testCase; i++) {
            String id = reader.next();
            int subjects = reader.nextInt();

            int tinChiTichLuy = 0;

            for (int j = 0; j < subjects; j++) {
                int score = reader.nextInt();
                if (score >= 50) {
                    tinChiTichLuy += 4;
                }
            }
            System.out.println(id + " " + tinChiTichLuy);
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