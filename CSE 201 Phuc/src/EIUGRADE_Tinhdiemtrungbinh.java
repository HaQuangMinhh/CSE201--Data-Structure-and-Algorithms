import java.util.*;
import java.io.*;

public class EIUGRADE_Tinhdiemtrungbinh {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Map<Integer, Student> listOfStudent = new HashMap<Integer, Student>();

		int cases = reader.nextInt();
		for (int i = 0; i < cases; i++) {
			int id = reader.nextInt();
			int codeSubject = reader.nextInt();
			double grade = reader.nextDouble();

			Student person = listOfStudent.get(id);
			if (person == null) {
				person = new Student(id);
				listOfStudent.put(id, person);
			}
			person.addGrade(grade);
		}

		List<Student> student = new ArrayList<>(listOfStudent.values());

		student.sort((s1, s2) -> {
			int compare = Double.compare(s2.averageGrade, s1.averageGrade);
			if(compare == 0) {
				compare = Integer.compare(s1.id, s2.id);
			}
			return compare;
		});

		for (Student i : student) {
			double avgGrade = (double)Math.round(i.averageGrade*1000)/1000 ;
			sb.append(i.id + " ").append(String.format("%3f",avgGrade) + "\n");
		}
		System.out.println(sb);
	}

	static class Student {
		private int id;
		private double totalGrade;
		private double averageGrade;
		private List<Double> grades;

		public Student(int id) {
			this.id = id;
			grades = new ArrayList<>();
		}

		public void addGrade(double grade) {
			grades.add(grade);
			totalGrade += grade;
//			averageGrade = (double)Math.round((totalGrade / (double)grades.size())*1000)/1000 ;
//			averageGrade = String.format("%3f",(totalGrade / grades.size()));
			averageGrade = totalGrade / grades.size();
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
