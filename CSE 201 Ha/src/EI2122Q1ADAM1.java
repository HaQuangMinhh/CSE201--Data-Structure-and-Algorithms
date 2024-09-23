import java.util.*;
import java.io.*;

public class EI2122Q1ADAM1 {
    static InputReader rd = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int N = rd.nextInt();
        int X = rd.nextInt();

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            int num = rd.nextInt();
            int target = num - X;

            if (frequencyMap.containsKey(target)) {
                count += frequencyMap.get(target);
            }

            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        sb.append(count);
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
