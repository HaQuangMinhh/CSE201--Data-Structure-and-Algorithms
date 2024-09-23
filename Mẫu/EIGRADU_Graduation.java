package week3;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;;

class EIGRADU_Graduation {

	public static void main(String[] args) {
		int numberStudents = ni();
		int minimumCredits = ni();

		List<Student> students = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numberStudents; i++) {
			int id = ni();
			String name = ns();
			int numberCourse = ni();

			Student student = new Student(id, name);

			for (int j = 0; j < numberCourse; j++) {
				int grade = ni();
				student.calGPA(grade);
			}
			students.add(student);
		}

		students.sort((s1, s2) -> {
			var compare = Double.compare(s2.average, s1.average);
			if (compare == 0) {
				compare = Integer.compare(s1.id, s2.id);
			}
			return compare;
		});
		
		for (Student student : students) {
			if (student.totalCredits >= minimumCredits) {
				sb.append(student.toString()).append("\n");
			}
		}
		System.out.println(sb);
	}

	static class Student {
		private int id;
		private String name;
		private int totalGrades;
		private int average;
		private int totalCredits;
		private int countSubjects;
		
		DecimalFormat df = new DecimalFormat("0");

		public Student(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		public void calGPA(int grade) {
			if (grade >= 50) {
				totalGrades += grade;
				totalCredits += 4;
				countSubjects++;
				average = totalGrades / countSubjects;
			}
		}

		@Override
		public String toString() {
			return id + " " + name + " " + df.format(Math.floor(average));
		}

	}

	static InputStream is = System.in;
	static byte[] inbuf = new byte[1 << 24];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static double nd() {
		return Double.parseDouble(ns());
	}

	static char nc() {
		return (char) skip();
	}

	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
}
