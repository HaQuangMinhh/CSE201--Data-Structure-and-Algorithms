import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


public class EISTOCK2 {

	static StringBuilder sb = new StringBuilder();
	static InputReader reader = new InputReader(System.in);
	
	public static void main(String[] args) {
		int n = reader.nextInt();
		
		Map<Integer, Product> map = new HashMap<>();
		
		for (int i = 0 ; i < n ; i++) {
			String type = reader.next();
			int id = reader.nextInt();
			int quantity = reader.nextInt();
			long value = reader.nextLong();
			int time = reader.nextInt();
			
			Transaction transaction = new Transaction(quantity, value , time); 
			Product product = map.getOrDefault( id , new Product(id)); 
			
			if ( type.equals("+")) {
				product.importValue(transaction); 
			} else {
				product.exportValue(quantity, value) ; 
			}
			
			map.put(id, product);  // update lại 
		}
		List<Product> products = new ArrayList<>(map.values()); // chạy các giá trị của map
		
		products.sort( (p1,p2 ) ->  {
			return Integer.compare(p1.id, p2.id);
		});
		
		for ( Product product : products) {
			if (product.totalProduct > 0 ) {
				sb.append(product).append("\n");
			}
		}
		System.out.println(sb);
		
		
	}
	
	static class Product {
		
		public Product(int id) {
			super();
			this.id = id;
			transactions = new ArrayDeque<>() ; 
		}
		int id ; 
		int totalProduct ; 
		long importPrice ; 
		Queue<Transaction> transactions;
		
		public void importValue( Transaction transaction ) {
			transactions.add( transaction );
			totalProduct += transaction.quantity; // lưu trữ tổng số lượng trong kho 
			importPrice += transaction.quantity * transaction.value ;
		}
		
		public void exportValue (int quantity , long value) {
			
			if ( quantity <= totalProduct ) {
				while (quantity > 0 ) {
					var transaction = transactions.peek();
					if (quantity >= transaction.quantity ) {
						
						quantity -= transaction.quantity; 
						totalProduct -= transaction.quantity ; 
						importPrice -= transaction.quantity * transaction.value; 
						transactions.poll();	
					} else {
						
						totalProduct -= quantity ; 
						importPrice -=  quantity * transaction.value;
						transaction.quantity -= quantity ; 
						quantity = 0 ;
					}
				}	
			}
		}
		
		public String toString() {
			long avg  = importPrice / totalProduct ; 
			int time = transactions.peek().time; 
			return id + " " + totalProduct + " " + avg + " " + time ;
			
		}
		
		
	}
	
	static class Transaction {   // nhập và xuất kho 
		
		public Transaction(int quantity, long value, int time) {
			super();
			this.quantity = quantity;
			this.value = value;
			this.time = time;
		}
		int quantity ; 
		long value ; 
		int time ; 
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
