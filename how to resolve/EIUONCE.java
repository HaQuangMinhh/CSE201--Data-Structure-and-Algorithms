
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class EIUONCE {

    static StringBuilder sb = new StringBuilder();  
    static InputReader rd = new InputReader(System.in);  
    public static void main(String[] args) {
        int num = rd.nextInt();

        for ( int i = 0 ; i < num ; i++ ) {

            int input = rd.nextInt();

            HashMap<Integer, Integer> hsMap = new HashMap<>(); // Lưu số lần xuất hiện 
            
            for ( int k = 0 ; k < input ; k++ ) {
                int key1 = rd.nextInt(); 
                hsMap.put(key1, hsMap.getOrDefault(key1, 0) + 1 );
            }

            TreeSet<Integer> uniqueNum = new TreeSet<>(); 
            for ( var entry : hsMap.entrySet() ) {
                if ( entry.getValue() == 1 ) {
                    uniqueNum.add(entry.getKey()); 
                }
            }

            // Show in uniqueNum
            for ( var score : uniqueNum ) {
                sb.append(score + " ");
            }
            sb.append("\n");
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
