
import java.util.*;
import java.io.*;

public class EIPAIR_BuyGifts {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {

        int testCase = reader.nextInt();

        for (int t = 0; t < testCase; t++) {
            int n = reader.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < n; i++) {
                prices[i] = reader.nextInt();
            }

            HashMap<Integer, Integer> priceCount = new HashMap<>();

            long pairs = 0;

            for (int price : prices) {
                // Count the occurrences of each price
                priceCount.put(price, priceCount.getOrDefault(price, 0) + 1);
            }

            // Calculate the number of pairs
            for (int count : priceCount.values()) {
                pairs += (long) count * (count - 1) / 2;
            }

            System.out.println(pairs);
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