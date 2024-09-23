import java.util.*;
import java.io.*;

public class EIUBISEA_BinarySearch {
    static InputReader rd = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = rd.nextInt();
        int testNum = rd.nextInt();
        int[] listNum = new int[n];
        int[] testList = new int[testNum];
        for (int i = 0; i < n; i++) {
            listNum[i] = rd.nextInt();
        }
        Arrays.sort(listNum);
        for (int j = 0; j < testNum; j++) {
            testList[j] = rd.nextInt();
            int result = binarySearch(listNum, testList[j]);
            sb.append(result).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static int binarySearch(int[] number, int key) {
        int left = 0, right = number.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (number[middle] == key) {
                while (middle > 0 && number[middle - 1] == key) {
                    middle--;
                }
                return middle;
            } else if (number[middle] < key) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}