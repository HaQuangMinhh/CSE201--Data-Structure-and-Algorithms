import java.util.*;
import java.io.*;

public class EIUTHU_Letter {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        String firstPart = reader.next();
        String secondPart = reader.next();
        int index = 0;
        for (int i = 1; i <= firstPart.length(); i++) {
            if (secondPart.charAt(0) == firstPart.charAt(firstPart.length() - i)) {// ki tu dau line2= ki tu cuoi line 1 ko
                if (check(firstPart, secondPart, index) != 0) {
                    index = i;
                }
            }
        }
        System.out.println(firstPart.length() + secondPart.length() - index);
    }

    public static int check(String firstPart, String secondPart, int index) {// kt cac gia tri tiep theo cos trung khong
        int j;
        for (j = 1; index > 0; j++) {
            if (secondPart.charAt(j) == firstPart.charAt(firstPart.length() - index)) {
                index--;
            } else {
                return 0;
            }
        }
        return j;
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