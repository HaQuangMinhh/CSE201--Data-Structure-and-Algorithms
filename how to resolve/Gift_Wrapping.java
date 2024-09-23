package baitap;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Gift_Wrapping {
    // EIUGIFT1

    static InputReader reader = new InputReader(System.in);
    
    public static void main(String[] args) {
    
    int giftNum = reader.nextInt();
    int WraNum = reader.nextInt();

    int[] gifts = new int[giftNum];
    int[] wraps = new int[WraNum];

    for ( int i = 0 ; i < giftNum ; i++) {
        gifts[i] = reader.nextInt();
    }
    for (int j = 0 ; j < WraNum ; j++) {
        wraps[j] = reader.nextInt();
    }

    Arrays.sort(gifts);
    Arrays.sort(wraps);
    
    int count = 0; 
    int k = 0 , h = 0;
    double t ;

    while ( k < giftNum && h < WraNum ) {
        t = (double) wraps[h] / gifts[k];
        if ( 2 <= t && t <= 3) {
            k++;
            h++;
            count++;
        } else if ( t < 2 ) {
            h++;
        } else 
            k++;
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
