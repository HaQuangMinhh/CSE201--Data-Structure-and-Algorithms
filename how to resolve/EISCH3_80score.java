import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class EISCH3_80score {

	
	static StringBuilder sb = new StringBuilder();
	static InputReader reader = new InputReader(System.in);
	
	public static void main(String[] args) {
		int studentNum = reader.nextInt();
		
		ArrayList<Student> StudentList = new ArrayList<>();
		for (int i = 0 ; i < studentNum ; i++) {
			String name = reader.next();
			String department = reader.next();
			
			int courseNum = reader.nextInt();
			int passed =  0 ; 
			double avg = 0 ; 
			
			for (int j = 0 ; j < courseNum ; j++) {
				int grade = reader.nextInt();
				
				if (grade > 49 ) {
					avg += grade ; 
					passed++;
				}
			}
			if (passed > 0 ) {
				avg /= passed ; 
			}
			StudentList.add( new Student(name, department, avg) );
		}
		
		StudentList.sort( (s1,s2) -> {
			int compare = Double.compare(s2.avg, s1.avg) ; 
			if (compare == 0) {
				compare = s1.name.compareTo(s2.name);
			}
			return compare ; 
		});
		
		int scholarship = 0 ; 
		
		HashMap<String, Integer> listScholarship = new HashMap<>(); 
		String type = "A"; 
		
		for (int s = 0 ; s < studentNum && scholarship < 10 ; s++) {
			Student st = StudentList.get(s);
			
			if (scholarship < 2 ) {
				scholarship++ ; 
			} else if (scholarship < 5) {
				type = "B" ; 
				if (listScholarship.getOrDefault(st.department, 0) == 2) {
					continue ; 
				} else {
					scholarship++ ; 
				}
			}
			else {
				type = "C";
				if (listScholarship.getOrDefault(st.department, 0) == 2 ) {
					continue ;  
				} else {
					scholarship++ ; 
				}
			}
			sb.append(st.name).append(" ")
			.append( (double) Math.round(st.avg * 100) / 100 ).append(" ")
			.append(type).append("\n");
			
			listScholarship.put(st.department, 
					listScholarship.getOrDefault(st.department, 0) + 1 );	
		}
		System.out.println(sb); 
	}
	static class Student {
		public Student(String name, String department, double avg) {
			super();
			this.name = name;
			this.department = department;
			this.avg = avg;
		}
		String name ; 
		String department ; 
		double avg = 0 ; 
		
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
