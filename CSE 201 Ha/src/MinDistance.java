import java.io.*;
import java.util.*;

public class MinDistance {

    static InputReader rd = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {


        int N = rd.nextInt();
        int K = rd.nextInt();

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = rd.nextInt();
        }

        Arrays.sort(array);

        int left = 1;
        int right = array[N - 1] - array[0];
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(array, N, K, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        sb.append(result);

        System.out.println(sb.toString());
    }

    private static boolean isValid(int[] array, int N, int K, int minDiff) {
        int count = 1;
        int prevElement = array[0];

        for (int i = 1; i < N; i++) {
            if (array[i] - prevElement >= minDiff) {
                count++;
                prevElement = array[i];
            }

            if (count >= K) {
                return true;
            }
        }

        return false;
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
