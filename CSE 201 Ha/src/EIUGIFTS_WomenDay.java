import java.util.*;
import java.io.*;

class EIUGIFTS_WomenDay {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int items = reader.nextInt();
        int amoutOfMoney = reader.nextInt();
        int[] prices = new int[items];
        for (int i = 0; i < items; i++) {
            prices[i] = reader.nextInt();
        }
        Arrays.sort(prices);
        int firstGiftIndex = 0;
        int secondGiftIndex = items - 1;
        int totalSpent = -1;
        int smallestDifference = Integer.MAX_VALUE;
        while (firstGiftIndex < secondGiftIndex) {
            int total = prices[firstGiftIndex] + prices[secondGiftIndex];

            if (total <= amoutOfMoney) {
                int difference = Math.abs(prices[firstGiftIndex] - prices[secondGiftIndex]);

                if (total > totalSpent || (total == totalSpent && difference < smallestDifference)) {
                    totalSpent = total;
                    smallestDifference = difference;
                }

                firstGiftIndex++;
            } else {
                secondGiftIndex--;
            }
        }

        if (totalSpent == -1) {
            System.out.println("-1 -1");
        } else {
            System.out.println(totalSpent + " " + smallestDifference);
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