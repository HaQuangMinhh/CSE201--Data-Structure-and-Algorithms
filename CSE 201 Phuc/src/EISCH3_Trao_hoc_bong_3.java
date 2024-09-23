import java.util.*;
import java.io.*;

// Not done 80
public class EISCH3_Trao_hoc_bong_3 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int totalOfStudents = reader.nextInt();
		Map<String, Integer> listOfDeparment = new HashMap<String, Integer>();
		List<Student> listOfStudents = new ArrayList<Student>();

		for (int i = 0; i < totalOfStudents; i++) {
			String name = reader.next();
			String deparment = reader.next();
			int totalOfSubjects = reader.nextInt();
			Student student = new Student(name, deparment);

			for (int j = 0; j < totalOfSubjects; j++) {
				student.addScore(reader.nextInt());
			}

			if (listOfDeparment.get(deparment) == null) {
				listOfDeparment.put(deparment, 0);
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

		int rewar = 0;
		int i = 0;

		while (rewar < 2 && i < totalOfStudents) {
			if (listOfDeparment.get(listOfStudents.get(i).deparment) < 2) {
				sb.append(
						listOfStudents.get(i).name + " " + listOfStudents.get(i).getAverageScore() + " " + "A" + "\n");
				listOfDeparment.put(listOfStudents.get(i).deparment,
						listOfDeparment.get(listOfStudents.get(i).deparment) + 1);
				rewar++;
			}
			i++;
		}

		while (rewar < 5 && i < totalOfStudents) {
			if (listOfDeparment.get(listOfStudents.get(i).deparment) < 2) {
				sb.append(
						listOfStudents.get(i).name + " " + listOfStudents.get(i).getAverageScore() + " " + "B" + "\n");
				listOfDeparment.put(listOfStudents.get(i).deparment,
						listOfDeparment.get(listOfStudents.get(i).deparment) + 1);
				rewar++;
			}
			i++;
		}

		while (rewar < 10 && i < totalOfStudents) {
			if (listOfDeparment.get(listOfStudents.get(i).deparment) < 2) {
				sb.append(
						listOfStudents.get(i).name + " " + listOfStudents.get(i).getAverageScore() + " " + "C" + "\n");
				listOfDeparment.put(listOfStudents.get(i).deparment,
						listOfDeparment.get(listOfStudents.get(i).deparment) + 1);
				rewar++;
			}
			i++;
		}

		System.out.println(sb);

	}

	static class Student {
		private String name;
		private String deparment;
		private double totalScore;
		private double averageScore;
		private List<Integer> score;

		public Student(String name, String deparment) {
			this.deparment = deparment;
			this.name = name;
			score = new ArrayList<Integer>();
		}

		public void addScore(int grade) {
			score.add(grade);
			totalScore += grade;
		}

		public double getAverageScore() {
			averageScore = totalScore / (double) score.size();
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