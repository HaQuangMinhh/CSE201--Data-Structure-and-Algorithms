import java.util.*;
import java.io.*;

// chua xog 95d
public class EISCHSH_Ranking {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		int cases = reader.nextInt();
		int scholarships = reader.nextInt();

		Map<Long, Student> listOfStudents = new HashMap<Long, Student>();

		for (int i = 0; i < cases; i++) {
			long id = reader.nextLong();
			String name = reader.next();
			int totalCourses = reader.nextInt();

			Student person = new Student(id, name);

			for (int j = 0; j < totalCourses; j++) {
				int grade = reader.nextInt();
				if (grade >= 50) {
					person.addGrade(grade);
				}
			}
			listOfStudents.put(id, person);
		}

		List<Student> students = new ArrayList<>(listOfStudents.values());
		students.sort((s1, s2) -> {
			int compare = Double.compare(s2.avg, s1.avg);
			if (compare == 0) {
				compare = Long.compare(s1.id, s2.id);
			}
			return compare;
		});
		int rank = 1;
		for (int i = 0; i < scholarships; i++, rank++) {

			if (rank != 1 && students.get(i).avg == students.get(i - 1).avg) {
				sb.append(rank - i + " ").append(students.get(i).id + " ").append(students.get(i).name + " ")
						.append((int) Math.round(students.get(i).avg) + "\n");
			} else {
				sb.append(rank + " ").append(students.get(i).id + " ").append(students.get(i).name + " ")
						.append((int) Math.round(students.get(i).avg) + "\n");
			}

		}
		
//		

		
		
//		
		System.out.println(sb);

	}

	static class Student {
		private long id;
		private String name;
		private double totalGrade;
		private double avg;
		private List<Integer> grades;

		public Student(long id, String name) {
			this.id = id;
			this.name = name;
			grades = new ArrayList<Integer>();
		}

		public void addGrade(int grade) {
			grades.add(grade);
			totalGrade += grade;
			avg = totalGrade / (double) grades.size();
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