import java.util.*;

import java.io.*;

 class EISTOCK {
    static InputReader rd = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int transactionNum = rd.nextInt();
        HashMap<Integer, Product> productList = new HashMap<>();
        for (int i = 0; i < transactionNum; i++) {
            
            String trans = rd.next();
            int code = rd.nextInt();
            int quantity = rd.nextInt();
            int price = rd.nextInt();

            Product pr = null;
            if (productList.containsKey(code)) {
                pr = productList.get(code);
            } else {
                pr = new Product(code);
                productList.put(code, pr);
            }
            if (trans.equals("-")) {
                if (pr.quantity >= quantity) {
                    pr.outItem(quantity, price);
                } 
            }
            else if (trans.equals("+")) {
                pr.inItem(quantity, price); // Moved this line to the correct block
            }
        }

        ArrayList<Product> productSorted = new ArrayList<Product>(productList.values());
        productSorted.sort((a, b) -> a.code - b.code);

        for (Product res : productSorted) {
            if (res.inItem != 0) {
                sb.append(res.code).append(" ").append(" ").append(res.inItem).append(" ")
                        .append(res.outItem).append("\n");
            }
        }
        System.out.println(sb);

    }

    static class Product {
        int code;
        long quantity = 0;
        long inItem = 0;
        long outItem = 0;

        public Product(int code) {
            this.code = code;
        }

        public void inItem(long quantity, long price) {
            this.quantity += quantity;
            inItem += price * quantity;
        }

        public void outItem(long quantity, long price) {
            this.quantity -= quantity;
            outItem += price * quantity;
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