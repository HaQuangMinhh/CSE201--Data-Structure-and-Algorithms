import java.util.*;
import java.io.*;

public class EISCH2_Scholarship_2 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		List<Student> listOfStudents = new ArrayList<Student>();
		int totalOfStudents = reader.nextInt();
		int topA = totalOfStudents / 12;
		int topB = totalOfStudents / 3;
		int topC = totalOfStudents / 2;

		for (int i = 0; i < totalOfStudents; i++) {
			String name = reader.next();
			int numOfSubjects = reader.nextInt();
			Student student = new Student(name);

			for (int j = 0; j < numOfSubjects; j++) {
				student.addScore(reader.nextInt());
			}
			listOfStudents.add(student);
		}

		listOfStudents.sort((s1, s2) -> {
			int compare = Double.compare(s2.getAverageScore(), s1.getAverageScore());
			if (compare == 0) {
				compare = s1.name.compareTo(s2.name);
			}
			return compare;
		});

		int i = 0;
		for (; i < topC; i++) {
			if (i < topA) {
				for (int j = 0; j < topA; j++) {
					if (listOfStudents.get(i).getAverageScore() != listOfStudents.get(topA).getAverageScore()) {
						sb.append(listOfStudents.get(i).name + " " + listOfStudents.get(i).getAverageScore() + " " + "A"
								+ "\n");
						i++;
					} else
						break;
				}
			}

			if (i < topB) {
				for (int j = 0; j < topB; j++) {
					if (listOfStudents.get(i).getAverageScore() != listOfStudents.get(topB).getAverageScore()) {
						sb.append(listOfStudents.get(i).name + " " + listOfStudents.get(i).getAverageScore() + " " + "B"
								+ "\n");
						i++;
					} else
						break;
				}
			}

			if (i < topC) {
				for (int j = 0; j < topC; j++) {
					if (listOfStudents.get(i).getAverageScore() != listOfStudents.get(topC).getAverageScore()) {
						sb.append(listOfStudents.get(i).name + " " + listOfStudents.get(i).getAverageScore() + " " + "C"
								+ "\n");
						i++;
					} else
						break;
				}
			}
		}
		
		System.out.println(sb);
		
	}

	static class Student {
		private String name;
		private double totalOfsroce;
		private double averageScore;
		private List<Integer> score;

		public Student(String name) {
			this.name = name;
			score = new ArrayList<Integer>();
		}

		public void addScore(int grade) {
			score.add(grade);
			totalOfsroce += grade;
		}

		public double getAverageScore() {
			averageScore = totalOfsroce / (double) score.size();
			return averageScore;
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