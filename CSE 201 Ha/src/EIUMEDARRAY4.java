import java.util.*;
import java.io.*;

public class EIUMEDARRAY4 {
    static InputReader rd = new InputReader(System.in);
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        int testCase = rd.nextInt();
        for (int i = 0; i < testCase; i++) {
            int n = rd.nextInt();
            int a = rd.nextInt();
            int p = rd.nextInt();
            int k = rd.nextInt();

            long[] array = calculateArray(n, a, p);
            Arrays.sort(array);
           long KthSmallestElement=array[k-1];
           sb.append(KthSmallestElement).append("\n");
            }
            System.out.println(sb.toString());
        }
    

    static long[] calculateArray(int n, int a, int p) {
        long[] array = new long[n];
        array[0] = (long) ((long) a * a % p);
        for (int i = 1; i < n; i++) {
            array[i] = (array[i - 1] * a) % p;
        }
        return array;
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