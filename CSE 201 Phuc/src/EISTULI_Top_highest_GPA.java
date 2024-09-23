import java.util.*;
import java.io.*;

//Done 100
public class EISTULI_Top_highest_GPA {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		int cases = reader.nextInt();
		int topOfHighest = reader.nextInt();

		List<Student> students = new ArrayList<>();
		
		for (int i = 0; i < cases; i++) {
			String id = reader.next();
			String name = reader.next();
			int totalCourse = reader.nextInt();

			Student person = new Student(id, name);

			for (int j = 0; j < totalCourse; j++) {
				int grade = reader.nextInt();
				if (grade >= 50) {
					person.addGrade(grade);
				}
			}
			students.add(person);
		}

		students.sort((s1, s2) -> {
			int compare = Double.compare(s2.averageScore, s1.averageScore);
			return compare;
		});

		for (int i = 0; i < topOfHighest; i++) {
            if (cases == topOfHighest) {
                sb.append(students.get(i).id + " ").append(students.get(i).name + " ")
                        .append((int) Math.round( students.get(i).averageScore) + " ").append(students.get(i).credits + "\n");
                continue;
            }
            if  (students.get(i).averageScore == students.get(topOfHighest).averageScore) {
                break;
            }
                sb.append(students.get(i).id + " ").append(students.get(i).name + " ")
                .append((int) Math.round( students.get(i).averageScore) + " ").append(students.get(i).credits + "\n");
        }

		System.out.println(sb);

	}

	static class Student {
		private String id;
		private String name;
		private List<Integer> grades;
		private double totalOfGrade;
		private double averageScore;
		private int credits;

		public Student(String id, String name) {
			this.id = id;
			this.name = name;
			grades = new ArrayList<Integer>();
		}

		public void addGrade(int grade) {
			grades.add(grade);
			totalOfGrade += grade;
			averageScore = (totalOfGrade / grades.size());
			credits += 4;
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
