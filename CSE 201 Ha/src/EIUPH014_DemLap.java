import java.util.*;
import java.io.*;

public class EIUPH014_DemLap {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        while (n != 0) {
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = reader.nextInt();
            }
            int count = 0;
            boolean kt = false;
            if (istheSame(arr) == true) {
                System.out.println(count);
            } else {
                while (kt == false && count < 1001) {
                    arr = process(arr, n);
                    count++;
                    kt = istheSame(arr);
                }
            }
            if (kt == false) {
                System.out.println(-1);
            } else {
                System.out.println(count);
            }
            n = reader.nextInt();
        }

    }

    public static boolean istheSame(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] process(int[] arr, int n) {
        int[] res = new int[n];
        for (int i = 0; i < n - 1; i++) {
            res[i] = Math.abs(arr[i] - arr[i + 1]);// hiêu số hiện tại và số kế tiếp
        }
        res[n - 1] = Math.abs(arr[n - 1] - arr[0]);// tính cuối trừ đầu
        return res;
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