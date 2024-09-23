import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EIPAGES {

	
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		
		int n = reader.nextInt();
		
		int[] numberPages = new int[n];
		
		for (int i = 0 ; i < numberPages.length; i++) {
			numberPages[i] = reader.nextInt();  // cho users input 
		}
		
		Arrays.sort(numberPages);
		
		for (int i = 0 ; i < n ; i++) {
			int start = numberPages[i];
			sb.append(start);
			
			int end = start;
			
			int count = 0;
			while (i + 1 < n && numberPages[i +1] - numberPages[i] == 1) {
				end = numberPages[i + 1];
				i++;
				count++;
			}
			if ( count >= 2) {
				sb.append("-").append(end);
			} else if (count == 1) {
				sb.append(" ").append(end);
			}
			
			sb.append(" ");
		}
		System.out.println(sb);
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
