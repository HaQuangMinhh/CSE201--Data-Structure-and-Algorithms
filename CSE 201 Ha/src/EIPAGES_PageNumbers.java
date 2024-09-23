import java.util.*;
import java.io.*;

 class EIPAGES_PageNumbers {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        int[] numberPages = new int[n];
        int i;
        for (i = 0; i < numberPages.length; i++) {
            numberPages[i] = reader.nextInt();
        }
        Arrays.sort(numberPages);
        int count = 1;
        for (i = 1; i <= numberPages.length; i++) {
            if (i < numberPages.length && numberPages[i] == numberPages[i - 1] + 1) {
                count++;
            } else {
                if (count >= 3) {
                    System.out.print(numberPages[i - count] + "-" + numberPages[i - 1] + " ");
                } else {
                    for (int j = i - count; j < i; j++) {
                        System.out.println(numberPages[j] + " ");
                    }
                }
                count = 1;
            }
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