import java.util.*;
import java.io.*;

public class EIUTHU_Letter {

	public static void main(String[] args) {
		String A = reader.next();
		String B = reader.next();
		
		System.out.println(A.length() + B.length());
		System.out.println(A.substring(5));
		
		
		
		
		
		

	}
static InputReader reader = new InputReader(System.in);
	
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
