package week3;

import java.io.*;
import java.util.*;;

class EISCHSH_Ranking {

	public static void main(String[] args) {
		int numberStudents = ni();
		int numberScholarships = ni();

		List<Student> students = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numberStudents; i++) {
			int id = ni();
			String name = ns();
			int numberCourses = ni();

			Student student = new Student(id, name);

			for (int j = 0; j < numberCourses; j++) {
				double grade = nd();
				student.calGrade(grade);
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

		if (numberScholarships > numberStudents) {
			numberScholarships = numberStudents;
		}

		while (numberScholarships < numberStudents && numberScholarships > 0
				&& students.get(numberScholarships).average == students.get(numberScholarships - 1).average) {
			numberScholarships++;
		}
		
		int rank = 1;
		for (int i = 0; i < numberScholarships; i++) {
			if (i > 0 && students.get(i).average < students.get(i - 1).average) {
				rank = i + 1;
			}
			
			sb.append(rank).append(" ").append(students.get(i).toString()).append("\n");
		}
		
		System.out.println(sb);
	}

	static class Student {
		private int id;
		private String name;
		private double totalGrades;
		private double totalCourses;
		private double average;

		public Student(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		public void calGrade(double grade) {
			if (grade >= 50) {
				totalGrades += grade;
				totalCourses++;
				average = totalGrades / totalCourses;
			}
		}

		@Override
		public String toString() {
			return id + " " + name + " " + Math.round(average);
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
