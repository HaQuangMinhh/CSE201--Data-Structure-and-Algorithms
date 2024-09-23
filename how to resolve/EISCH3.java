import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class EISCH3 {

	
	static StringBuilder sb = new StringBuilder();
	static InputReader reader = new InputReader(System.in);
	
	public static void main(String[] args) {
		
		int n = reader.nextInt();
		
		List<Student> studentList = new ArrayList<>(); // lưu Student
		
		Map<String, Integer> departmentCount = new HashMap<>(); // đếm số lượng theo từng khoa
		
		int[] scholarshipCount = new int[3]; // học bổng cấp cho mỗi loại 
		
		for (int i = 0 ; i < n ; i++) {
			String name = reader.next();
			String department = reader.next();
			
			int totalSubject = reader.nextInt();
			double sum = 0.0;
			
			for (int j = 0 ; j < totalSubject ; j++) {
				sum += reader.nextInt();
			}
			
			Student student = new Student(name , department , sum / totalSubject);
			studentList.add(student);
		}
		
		studentList.sort( (s1, s2) ->  {
			int compare = Double.compare(s2.average , s1.average) ; 
			
			if (compare == 0 ) {
				compare = s1.name.compareTo(s2.name);
			}
			return compare ; 
		});
		
		// Khởi tạo các biến liên quan đến học bổng 
		String[] types = new String[] { "A" , "B" , "C" };
		
		int[] scholarshipLimits = new int[] {2, 5 , 10}; // giới hạn scholarship 
		int[] scholarshipTemp = new int[] {2 , 5 , 10}; // để kiểm tra 
		
		int temp = 0 ; 
		if (studentList.size() > 1 ) {
			while (studentList.get(0).average == 
					studentList.get( scholarshipLimits[temp]).average  ) {
				if ( temp >= scholarshipLimits.length - 1  ) {
					System.out.println("");
					return ; 
				}
				temp++;
			}
		}
		// phân phối học bổng 
		for (Student student : studentList) {
			
			for (int i = 0 ; i < 3 ; i++) {
				if ( scholarshipCount[i] < scholarshipLimits[i] ) {
					if ( departmentCount.getOrDefault(student.department, 0 ) >= 2 ) {
						scholarshipTemp[i]++ ; 
						break ; 
					}
					
					if ( i == 1 && scholarshipCount[0] + scholarshipCount[1] >= 5 ) {
						continue ; 
					}
					if ( i == 2 && scholarshipCount[0] + scholarshipCount[1] + 
							scholarshipCount[2] >= 10) {
						break ; 
					}
					
					if ( i < (scholarshipLimits.length - 1) && studentList.size() 
							> scholarshipLimits[i] ) {
						if (student.average == 
								studentList.get(scholarshipTemp[i]).average) {
							
							sb.append(student).append(types[ i + 1 ]).append("\n");
							scholarshipCount[i]++; 
							
							departmentCount.put(student.department, 
									departmentCount.getOrDefault(student.department,
											0)+ 1);
							break;  
						}
					}
					sb.append(student).append(types[i]).append("\n");
					scholarshipCount[i]++ ; 
					departmentCount.put(student.department, 
							departmentCount.getOrDefault(student.department, 
									0) + 1);
					break ; 
				}
			}	
		}
		System.out.println(sb);
	}
	static class Student {
		public Student(String name, String department, double average) {
			super();
			this.name = name;
			this.department = department;
			this.average = average;
		}
		String name ; 
		String department ; 
		double average ; 
		
		public String toString() {
			return name + " " + (double) Math.round(average * 100) / 100 + " "; 
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
