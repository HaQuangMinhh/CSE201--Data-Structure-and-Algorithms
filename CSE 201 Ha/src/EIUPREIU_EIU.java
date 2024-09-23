import java.util.*;
import java.io.*;

public class EIUPREIU_EIU {
    static InputReader reader = new InputReader(System.in);
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        int n = reader.nextInt();
        String space = "";
        String dash = "";
        for (int i = 0; i < n / 2; i++) {
            dash += "_";
            space += " ";
        }
        System.out.println(" " + dash + space + "     ");

        for (int d = 0; d < n / 2 - 1; d++) {
            System.out.println("|" + space + " | |" + space + "|");
        }
        System.out.println("|" + dash + " | |" + space + "|");
        for (int d2 = 0; d2 < n / 2 - 1; d2++) {
            System.out.println("|" + space + " | |" + space + "|");
        }
        System.out.print("|" + dash + " | |" +dash+ "|\n");
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