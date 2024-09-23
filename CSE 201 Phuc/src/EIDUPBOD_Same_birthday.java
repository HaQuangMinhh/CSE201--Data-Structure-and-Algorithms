import java.util.*;
import java.io.*;
import java.util.Scanner;

public class EIDUPBOD_Same_birthday {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();

		Map<String, Date> listOfDate = new HashMap<String, Date>();
		for (int i = 0; i < cases; i++) {
			sb = new StringBuilder();
			int day = sc.nextInt();
			int month = sc.nextInt();
			int year = sc.nextInt();
			
			if (day < 10) {
				sb.append("0");
			}
			sb.append(day + "/");
			
			if (month < 10) {
				sb.append("0");
			}
			
			sb.append(month + "/");
			sb.append(year);

			Date birthday = listOfDate.get(sb.toString());
			if (birthday == null) {
				birthday = new Date(day, month, year, sb.toString());
				listOfDate.put(sb.toString(), birthday);
			}
			birthday.count++;
		}


		List<Date> birthday = new ArrayList<>(listOfDate.values());
		birthday.sort((b1, b2) -> {
			int compare = b1.year - b2.year;

			if (compare == 0) {
				compare = b1.month - b2.month;
				if (compare == 1) {
					return compare;
				}
				if (compare == -1) {
					return compare;
				}
				if (compare == 0) {
					compare = b1.day - b2.day;
					if (compare == 0) {
						return compare;
					} else if (compare == 1) {
						return compare;
					} else
						return compare;
				}
			}
			if (compare == 1) {
				return compare;
			} else
				return compare;
		});
		for (Date i : birthday) {
			System.out.println(i.dob + " " + i.count);
		}

	}

	static class Date {
		public int day;
		public int month;
		public int year;
		public String dob;
		public int count;

		public Date(int day, int month, int year, String dob) {
			this.day = day;
			this.month = month;
			this.year = year;
			this.dob = dob;
		}
	}
}
