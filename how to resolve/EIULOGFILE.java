import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EIULOGFILE {

	
	static StringBuilder sb = new StringBuilder();
	static InputReader reader = new InputReader(System.in);
	
	public static void main(String[] args) {
		
		int n = reader.nextInt();
		
		long[] logFile = new long[n];
		for (int i = 0 ; i < n ; i++ ) {
			logFile[i] = reader.nextLong();
		}
		
		Arrays.sort(logFile);
		
		// đếm số cặp tệp nhật ký
		long count = 0 ; 	// biến đếm 
		int j = 0 ; 		// con trỏ 
		
		for (int i = 0 ; i < n ; i++) {
			while (j < n && logFile[j] - logFile[i] <= 600000 ) {
				j++ ;
			}
			
			count += j - i - 1 ; 
			
		}
		System.out.println(count);
		
		
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
