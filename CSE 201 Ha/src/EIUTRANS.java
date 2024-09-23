import java.util.*;
import java.io.*;

public class EIUTRANS {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();// so tu Beo muon noi
        int testCase = reader.nextInt();
        
        Map<String, String> dictionary = new HashMap<>();
        for (int i = 0; i < testCase; i++) {
            String wordA = reader.next();
            String wordB = reader.next();
            if (wordA.length() > wordB.length()) {
                dictionary.put(wordA, wordB);
            } else {
                dictionary.put(wordA, wordA);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            String nhap = reader.next();
            // dictionary.get(nhap);

            sb.append(dictionary.get(nhap)).append(" ");
        }
        System.out.println(sb);
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
