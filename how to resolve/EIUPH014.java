import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EIUPH014 {

	static InputReader reader = new InputReader(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = reader.nextInt();
		
		int[] arr = new int[n];
		
		for (int i = 0 ; i < arr.length ; i++) {
			arr[i] = reader.nextInt();
		}
		
		int count = 0 ; 
		while ( n != 0 ) {
			while ( !isSame(arr) && n != 0 ) {
				int t = arr[0];
				int i = 0 ; 
				for (; i < arr.length - 1 ; i++) {
					arr[i] = Math.abs(arr[i] - arr[i + 1]);
				}
				arr[i] = Math.abs(arr[i] - t) ; 
				count++;
				if (count > 1000) 
					break;
			}
			if (count > 1000) {
				System.out.println(-1);
			}
			else 
				System.out.println(count);
			
			n = reader.nextInt();
			arr = new int[n];
			for (int i = 0 ; i < arr.length ; i++) {
				arr[i] = reader.nextInt();
			}
			count = 0;
		}
		
	}
	
	public static boolean isSame(int[] a) {   // Hàm kiểm tra xem nó giống nhau không 
		for (int i = 0 ; i < a.length - 1; i++) {
			if (a[i] != a[i + 1] ) {
				return false ; 
			}
		}
		return true ;
		
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
