import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class EIUPH010 {

	
	static InputReader reader = new InputReader(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = reader.nextInt();
		
		int[] arr = new int[n];
		
		for (int i = 0 ; i < arr.length ; i++) {
			arr[i] = reader.nextInt();
		}
		
		HashMap<Integer, Integer> countQuantity = new HashMap<>();
		
		for (int num : arr) {
			countQuantity.put(num, countQuantity.getOrDefault(num, 0) + 1);
		}
		
		int mostNumber = arr[0];
		int maxCount = 0; 
		for (int num : countQuantity.keySet() ) {
			int count = countQuantity.get(num);
			if (count > maxCount) {
				mostNumber = num ; 
				maxCount = count;
			}
			
		}
		System.out.println(mostNumber + " " + maxCount);
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
