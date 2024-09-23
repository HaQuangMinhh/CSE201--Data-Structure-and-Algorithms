import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class EICARDSYS {

	static StringBuilder sb = new StringBuilder();
    static InputReader reader = new InputReader(System.in);
    
	public static void main(String[] args) {
		
		int n = reader.nextInt(); 

        Map<String, Double> map = new HashMap<>();  // lưu tổng số tiền của khách hàng 
        double pay = 0 ; // tổng số tiền được giảm giá 
        double newMoney ; // tiền mới của khách hàng 

        for (int i = 0 ; i < n ; i++) {
            String id = reader.next(); 
            double money = reader.nextDouble(); // đọc giá trị giao dịch 
            double dis = 0 ; // khởi tạo giảm giá = 0 ; 

            if ( map.get(id) != null ) {
                dis = calculateDisc(map.get(id)); // tính giảm giá cho khách hàng đã mua rồi 
            }
            pay += money * dis ; // cộng các số tiền đã giảm giá 

            if ( map.get(id) == null ) {
                map.put(id, money) ; // nếu Custumers ch tồn thì add thêm
            } else {
                newMoney = map.get(id) + money ; // Update số tiền  
                map.put(id, newMoney);  // Update giá trị mới 
            }
        }
        pay = Math.round (pay * 100) ;
        System.out.println( pay / 100 );
    }
    static double calculateDisc (double m ) {
        double mil = 1000000 ;
        double dis = 0 ; 
        
        if ( m < mil ) {
            dis = 0 ;  // ít hơn 1tr. NOT discount 
        } else if ( m < 20 * mil ) { 
            dis = 0.02 ; // dưới 20tr, giảm giá 2% 
        } else if ( m < 50 * mil ) {
            dis = 0.03 ; 
        } else if ( m < 200 * mil ) {
            dis = 0.05  ; 
        } else {
            dis = 0.07 ; 
        } 

        return dis ; 
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
