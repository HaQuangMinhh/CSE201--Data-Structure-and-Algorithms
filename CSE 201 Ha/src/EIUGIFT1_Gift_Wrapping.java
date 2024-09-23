import java.util.*;
import java.io.*;

 class EIUGIFT1_Gift_Wrapping {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int gifNum = reader.nextInt();
        int wraNum = reader.nextInt();
        double[] gifts = new double[gifNum];
        double[] wraps = new double[wraNum];
        for (int i = 0; i < gifNum; i++) {
            gifts[i] = reader.nextDouble();
        }
        for (int j = 0; j < wraNum; j++) {
            wraps[j] = reader.nextDouble();
        }
        Arrays.sort(gifts);
        Arrays.sort(wraps);
        int maxGifts = 0;
        int k = 0;
        int h = 0;
        while (k < gifNum && h < wraNum) {

            if (gifts[k] * 2 <= wraps[h] && wraps[h] <= gifts[k] * 3) {
                maxGifts++;
                k++;
                h++;
            } else if (gifts[k] * 2 > wraps[h]) {
                h++;
            } else {
                k++;
            }

        }
        System.out.println(maxGifts);
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
