import java.util.*;

import java.io.*;

// chua xog 96.67
public class EIUSLS_Scholarships {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int numOfStudent = reader.nextInt();

		List<Student> students = new ArrayList<>();
		
		for (int i = 0; i < numOfStudent; i++) {
			String name = reader.next();
			int totalCourses = reader.nextInt();

			Student person = new Student(name);
			for (int j = 0; j < totalCourses; j++) {
				int grade = reader.nextInt();
				person.addGrade(grade);

			}
			students.add(person);
		}

		students.sort((s1, s2) -> {
			int compare = Double.compare(s2.avg, s1.avg);
			return compare;
		});

		int i = 0;
		int k = 0;
		for (; i < 2 && k < numOfStudent; i++, k++) {
			sb.append(students.get(i).name + "\n");

		}
		System.out.println(sb);
	}

	static class Student {
		private String name;
		private double totalGrade;
		private double avg;
		private List<Integer> grades;

		public Student(String name) {
			this.name = name;
			grades = new ArrayList<Integer>();
		}

		public void addGrade(int grade) {
			grades.add(grade);
			totalGrade += grade;
			avg = Math.round(totalGrade / (double) grades.size());
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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
