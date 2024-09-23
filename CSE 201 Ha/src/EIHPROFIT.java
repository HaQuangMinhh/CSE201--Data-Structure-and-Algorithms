import java.util.*;
import java.io.*;

 class EIHPROFIT {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        int k = reader.nextInt();
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int id = reader.nextInt();
            String name = reader.next();
            int price = reader.nextInt();
            int cost = reader.nextInt();
            int quantitySold = reader.nextInt();

            int getProfit = (price - cost) * quantitySold;
            products.add(new Product(id, name, price, cost, quantitySold, getProfit));
        }

        products.sort((p1, p2) -> Integer.compare(p2.getProfit, p1.getProfit));

        int ctr = 0;
        int topProfit = Integer.MIN_VALUE;

        StringBuilder sb = new StringBuilder();

        for (Product product : products) {
            if (ctr >= k && product.getProfit < topProfit) {
                break;
            }

            sb.append(product.id).append(" ").append(product.name).append(" ").append(product.getProfit)
                    .append("\n");

            if (ctr < k) {
                topProfit = product.getProfit;
            }

            ctr++;
        }

        System.out.println(sb.toString());
    }

    static class Product {
        int id;
        String name;
        int price;
        int cost;
        int quantitySold;
        int getProfit;

        public Product(int id, String name, int price, int cost, int quantitySold, int getProfit) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.cost = cost;
            this.quantitySold = quantitySold;
            this.getProfit = getProfit;
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
