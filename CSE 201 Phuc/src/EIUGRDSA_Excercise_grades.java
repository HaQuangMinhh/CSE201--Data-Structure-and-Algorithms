import java.util.*;
import java.io.*;

public class EIUGRDSA_Excercise_grades {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Map<Integer, Student> listOfStudent = new HashMap<Integer, Student>();

		int totalOfStudents = reader.nextInt();
		int totalOfProblems = reader.nextInt();
		int totalOfSubmission = reader.nextInt();

		for (int i = 0; i < totalOfStudents; i++) {
			int id = reader.nextInt();
			Student stu = new Student(id, totalOfProblems);
			listOfStudent.put(id, stu);
		}
		for (int i = 0; i < totalOfProblems; i++) {
			int codeExercise = reader.nextInt();
		}

		for (int i = 0; i < totalOfSubmission; i++) {
			int id = reader.nextInt();
			int codeExercise = reader.nextInt();
			int score = reader.nextInt();
			listOfStudent.get(id).addGrade(codeExercise, score);
		}
		List<Student> students = new ArrayList<>(listOfStudent.values());
		students.sort((s1, s2) -> {
			int compare = Integer.compare(s1.id, s2.id);
			return compare;
		});
		for (Student i : students) {
			sb.append(i.id + " ").append((int) i.getAvg() + "\n");
		}
		System.out.println(sb);

	}

	static class Student {
		private int id;
		private long totalOfGrade;
		private int totalOfProblems;
		private double avg;
		private HashMap<Integer, Integer> grades;

		public Student(int id, int totalOfProblems) {
			this.id = id;
			this.totalOfProblems = totalOfProblems;
			grades = new HashMap<Integer, Integer>();
		}

		public void addGrade(int codeExercise, int grade) {
			if (grades.get(codeExercise) == null) {
				grades.put(codeExercise, grade);
			} else {
				grades.put(codeExercise, (Math.max(grades.get(codeExercise), grade)));
			}

		}

		public double getAvg() {
			for (int i : grades.keySet()) {
				totalOfGrade += grades.get(i);
			}
			avg = totalOfGrade / totalOfProblems;
			return avg;
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