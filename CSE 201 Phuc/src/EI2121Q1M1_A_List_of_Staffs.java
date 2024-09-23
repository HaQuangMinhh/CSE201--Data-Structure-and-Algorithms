import java.util.*;

import java.io.*;

public class EI2121Q1M1_A_List_of_Staffs {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int cases = reader.nextInt();
		List<Staff> listOfStaffs = new ArrayList<Staff>();

		for (int i = 0; i < cases; i++) {
			int id = reader.nextInt();
			String name = reader.next();
			int year = reader.nextInt();

			Staff staff = new Staff(id, name, year);
			
			listOfStaffs.add(staff);
		}

//		List<Staff> staffs = new ArrayList<>(listOfStaffs.values());
		listOfStaffs.sort((s1, s2) -> {
			int compare = Double.compare(s2.yearold, s1.yearold);
			if (compare == 0) {
				compare = Integer.compare(s1.id, s2.id);
			}
			return compare;
		});

		for (Staff i : listOfStaffs) {
			sb.append(i.id + " " + i.name + " " + i.yearold + "\n");		
		}
		System.out.println(sb);

	}

	static class Staff {
		private int id;
		private String name;
		private int yearold;

		public Staff(int id, String name, int year) {
			this.id = id;
			this.name = name;
			yearold = 2021 - year;
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