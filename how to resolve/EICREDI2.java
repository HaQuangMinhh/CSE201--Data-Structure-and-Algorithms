import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class EICREDI2 {

	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int testcases = reader.nextInt(); // number of students 
		
		for (int i = 0 ; i < testcases ; i++) {
			int count = 0; 
			double avg = 0;
			
			String name = reader.next();
			sb.append(name + " ");
			
			int totalSubjects = reader.nextInt();
			for (int j = 0 ; j < totalSubjects ; j++) {
				double grade = reader.nextDouble();
				
				if (grade >= 50) {
					count++;
					avg += grade ; 
					sb.append((int) grade + " ");
				}
			}
			
			if (count == 0)  {
				sb.append(0 + "\n");
			} else 
				sb.append( (int) avg / count + "\n" );
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
