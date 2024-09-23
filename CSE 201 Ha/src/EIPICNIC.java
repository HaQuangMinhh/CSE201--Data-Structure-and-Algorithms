import java.util.*;
import java.io.*;

class EIPICNIC {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        int[] xe = new int[] { 0, 0, 0, 0, 0 };
        for (int i = 0; i < n; i++) {
            int group = reader.nextInt();
            xe[group]++;
        }
        int carNum = 0;
        carNum += xe[4];

        if (xe[3] - xe[1] >= 0)
        {
            carNum += xe[3];
            xe[1] = 0;
        } else {
            xe[1] = xe[1] - xe[3];
            carNum+=xe[3];
        }
        carNum += xe[2] / 2;
        if (xe[2] % 2 != 0) {
            xe[2] = 1;
        } else {
            xe[2] = 0;
        }
        carNum += xe[1] / 4;
        xe[1] = xe[1] % 4;

        carNum += (xe[1] + xe[2] * 2) / 4;
        xe[1] = (xe[1] + xe[2] * 2) % 4;
        if (xe[1] != 0) {
            carNum++;
        }
        System.out.println(carNum);
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
