import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


public class EISTOCK {

	static StringBuilder sb = new StringBuilder();
	static InputReader reader = new InputReader(System.in);
	
	public static void main(String[] args) {
		int transactionNum = reader.nextInt();
		
		HashMap<Integer, Product> productList = new HashMap<>();
		
		for (int i = 0 ; i < transactionNum ; i++) {
			String trans = reader.next(); // loại giao dịch 
			int code = reader.nextInt();	// mã san pham 
			long quantity = reader.nextLong(); 	
			int price = reader.nextInt();
			
			// kiểm tra xem đã tồn tại ch 
			Product pr = null ; 
			if (productList.containsKey(code)) {
				pr = productList.get(code) ; 
			} else {
				pr = new Product(code) ; 
				productList.put(code, pr);
			}
			
			// xử lý nhập xuất 
			if ( trans.equals("-") ) {
				if (pr.quantity >= quantity ) {
					pr.outItem(quantity, price);
				}
			} else if ( trans.equals("+") ) {
				pr.inItem(quantity, price);
			}
		}
		
	ArrayList<Product> productSorted = new ArrayList<Product>(productList.values()); 
		productSorted.sort( (a,b) -> a.code - b.code);
		
		// duyệt 
		for (Product res : productSorted) {
			if (res.inItem != 0 ) {
				sb.append(res.code).append(" ").append(" ").append(res.inItem)
				.append(" ").append(res.outItem).append("\n");
			}	
		}
		System.out.println(sb);
	}
	
	static class Product {
		
		public Product(int code) {
			super();
			this.code = code;
		}
		int code ;
		long quantity = 0 ; 
		long inItem ; 
		long outItem ;
		
		public void outItem ( long quantity , long price ) {
			this.quantity -= quantity ; // giảm số lượng có trong kho 
			outItem += price * quantity ; 
		}
		public void inItem ( long quantity , long price ) {
			this.quantity += quantity ; 
			inItem += price * quantity ; 
			
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
