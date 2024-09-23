import java.util.*;
import java.io.*;

class EIUONCE_DistinctValue {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int testCase = reader.nextInt();
        for (int i = 0; i < testCase; i++) {
            int n = reader.nextInt();
            HashMap<Integer, Integer> listNum = new HashMap<>();// lưu số lần xuất hiện của số
            for (int j = 0; j < n; j++) {
                int key = reader.nextInt();
                listNum.put(key, listNum.getOrDefault(key, 0) + 1);
            }
            var keyList = listNum.keySet();
            ArrayList<Integer> sortlist = new ArrayList<Integer>();
            for (int keys : keyList) {
                if (listNum.get(keys) == 1) {
                    sortlist.add(keys);
                }
            }
            sortlist.sort(null);
            for (int num : sortlist) {
                System.out.print(num + " ");
            }
            System.out.println();
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
