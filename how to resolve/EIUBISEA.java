import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EIUBISEA {

	
	static StringBuilder sb = new StringBuilder();
	static InputReader reader = new InputReader(System.in);
	
	public static void main(String[] args) {
		int N = reader.nextInt();
		int M = reader.nextInt();
		
		int[] arr = new int[N];
		
		for (int i = 0 ; i < N ; i++) {
			arr[i] = reader.nextInt();
		}
		
		Arrays.sort(arr); 
		
		for (int i = 0 ; i < M ; i++) {
			int searchNum = reader.nextInt();
			int result = binarySearch (arr, searchNum) ; 
			sb.append(result).append(" ");
		}
		
		System.out.println(sb);
		
	}
	
	public static int binarySearch ( int[] arr, int target) {
		int left = 0 ; // vị trí đầu tiên 
		int right = arr.length - 1 ; // vị trí cuối cùng 
		
		while (left <= right) {
			int mid = left + (right - left) / 2 ; // tính vị trí giữa 
			
			if (arr[mid] == target ) {
				while ( mid > 0 && arr[mid - 1] == target) { //
					mid-- ; 
				}
				return mid ; 
			} else if ( arr[mid] < target ) {
				left = mid + 1 ;
			} else 
				right = mid - 1 ;
		} 
		return -1 ; 
		
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
