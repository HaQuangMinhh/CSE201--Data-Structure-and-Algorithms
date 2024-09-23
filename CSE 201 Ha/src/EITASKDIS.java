import java.io.*;
import java.util.*;

public class EITASKDIS {
	static InputReader rd = new InputReader(System.in);
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		int peopleNum = rd.nextInt();
		int taskNum = rd.nextInt();

		ArrayList<Integer> listTasks = new ArrayList<>();

		for (int i = 0; i < taskNum; i++) {
			listTasks.add(rd.nextInt());
		}

		listTasks.sort((t1, t2) -> t2 - t1);

		ArrayList<People> listPeople = new ArrayList<>();

		PriorityQueue<People> taskMap = new PriorityQueue<>((p1, p2) -> {
			int compare = Integer.compare(p1.totalWorkTime, p2.totalWorkTime);
			if (compare == 0) {
				compare = Integer.compare(p1.index, p2.index);
			}
			return compare;
		});
		int index = 0;

		for (int j = 0; j < peopleNum; j++) { 
			People p = new People(listTasks.get(index++), j);
			listPeople.add(p);
			taskMap.add(p);
		}

		while (index < taskNum) {
			People p = taskMap.poll();
			p.totalWorkTime += listTasks.get(index++);
			
			if (taskMap.isEmpty()) {
				for (People temP : listPeople) {
					taskMap.add(temP);
				}
			}
		}

		for (People p : listPeople) {
			sb.append(p.totalWorkTime).append(" ");
		}
		System.out.println(sb);
	}

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

class People {
	int index;
	int totalWorkTime;

	public People(int task, int index) {
		this.index = index;
		this.totalWorkTime += task;
	}

}