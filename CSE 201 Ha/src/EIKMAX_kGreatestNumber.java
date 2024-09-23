import java.util.*;
import java.io.*;

class EIKMAX_kGreatestNumber {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = reader.nextInt();
        int k = reader.nextInt();

        HashMap<Integer, Integer> numbers = new HashMap<>();
        List<Integer> uniqueNumbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int number = reader.nextInt();
            numbers.put(number, numbers.getOrDefault(number, 0) + 1);
            if (!uniqueNumbers.contains(number)) {
                uniqueNumbers.add(number);
            }
        }

        uniqueNumbers.sort(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            int maxNum = uniqueNumbers.get(i);
            int fr = numbers.get(maxNum);
            if (fr > 1) {
                numbers.put(maxNum, fr - 1);
            } else {
                numbers.remove(maxNum);
                uniqueNumbers.remove(i);
                i--;
                k--;
            }

            sb.append(maxNum).append(" ");
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