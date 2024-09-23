import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class EIUONCE {
    
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        int n = reader.nextInt();

        for (int i = 0 ; i < n ; i++) {
            int input = reader.nextInt(); // users input
			HashMap<Integer, Integer> lstNum = new HashMap<>(); // lưu số lần xuất hiện 
			for ( int k = 0 ; k < input ; k++) {
				int key1 = reader.nextInt();
				lstNum.put (key1 , lstNum.getOrDefault( key1 , 0 ) + 1);
			} 
			var keyList = lstNum.keySet(); // trả về các key trong lstNum.
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			for (int keys : keyList) {
				if (lstNum.get(keys) == 1) {
					list.add(keys);
				}
			}

			list.sort(null);
			for (int num : list ) {
				System.out.print(num + " ");
			}
			System.out.println();
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
