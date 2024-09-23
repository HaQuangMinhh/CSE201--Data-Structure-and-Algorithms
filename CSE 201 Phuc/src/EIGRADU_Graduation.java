import java.util.*;
import java.io.*;

public class EIGRADU_Graduation {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int cases = reader.nextInt();
		int minimumCredits = reader.nextInt();
		
		Map<Integer, Student> listOfStudents = new HashMap<Integer, Student>();
		
		for(int i = 0; i < cases; i++) {
			int id = reader.nextInt();
			String name = reader.next();
			int totalCourse = reader.nextInt();
			
			Student person = new Student(id, name);
			
			for(int j = 0; j < totalCourse; j++) {
				int grade = reader.nextInt();
				if(grade >= 50) {
					person.addGrade(grade);
				}
			}
			listOfStudents.put(person.id, person);
		}
		
		List<Student> students = new ArrayList<>(listOfStudents.values());
		students.sort((s1, s2) -> {
			int compare = Double.compare(s2.averageScore, s1.averageScore);
			if(compare == 0) {
				compare = Integer.compare(s1.id, s2.id);	
			}
			return compare;
		});
		
		for (Student i : students) {
			if(i.credits >= minimumCredits) {
				System.out.println(i.id + " " + i.name + " "+ (int)i.averageScore);
			}
		}
	}

	static class Student {
		private int id;
		private String name;
		private List<Integer> grades;
		private int totalOfGrade;
		private double averageScore;
		private int credits;

		public Student(int id, String name) {
			this.id = id;
			this.name = name;
			grades = new ArrayList<Integer>();
		}

		public void addGrade(int grade) {
				grades.add(grade);
				totalOfGrade += grade;
				averageScore = totalOfGrade / grades.size();
				credits+=4;
		}
		
	}

	static InputReader reader = new InputReader(System.in);

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