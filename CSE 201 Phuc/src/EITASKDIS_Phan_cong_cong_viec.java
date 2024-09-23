import java.util.*;
import java.io.*;

public class EITASKDIS_Phan_cong_cong_viec {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int totalWorkers = reader.nextInt();
		int totalTasks = reader.nextInt();

		PriorityQueue<Worker> jobs = new PriorityQueue<>((j1, j2) -> {
			int compare = Integer.compare(j1.totalWorkTimes, j2.totalWorkTimes);
			if (compare == 0) {
				compare = Integer.compare(j1.index, j2.index);
			}
			return compare;
		});
		ArrayList<Integer> listWorker = new ArrayList<>();
		for (int i = 0; i < totalWorkers; i++) {
			listWorker.add(i);
		}

		ArrayList<Worker> workerList = new ArrayList<>();
		for (int i = 0; i < totalWorkers; i++) {
			Worker worker = new Worker(listWorker.get(i), 0);
			workerList.add(worker);
			jobs.add(worker);
		}
		
		ArrayList<Integer> timeList = new ArrayList<>();
		for (int i = 0; i < totalTasks; i++) {
			int hour = reader.nextInt();
			timeList.add(hour);
		}
		
		timeList.sort((h1,h2)->{
			int compare = Integer.compare(h2, h1);
            return compare;
		});
		
		for(int i =0; i < totalWorkers; i++) {
			Worker worker = new Worker(i, timeList.get(i));
			workerList.set(i, worker);
			
		}
		
		workerList.sort((a1, a2) -> {
			int compare = Integer.compare(a2.totalWorkTimes, a1.totalWorkTimes);
			if (compare == 0) {
				compare = Integer.compare(a1.index, a2.index);
			}
			return compare;
		});

		for (int i = 0; i < totalTasks - totalWorkers; i++) {
			Worker worker = jobs.poll();
			int hour = timeList.get(i);
			worker.totalWorkTimes += hour;
//			arr.get(i).totalWorkTimes = worker.totalWorkTimes;
			jobs.add(worker);
		}
//		ArrayList<Worker> list = new ArrayList<>();
//		for (Worker e : jobs) {
//			list.add(e);
//		}
//		list.sort((o1, o2) -> {
//			int compare = Integer.compare(o1.index, o2.totalWorkTimes);
//			return compare;
//		});
		for (Worker e : workerList) {
			sb.append(e.totalWorkTimes + " ");
		}
		System.out.println(sb);

	}

	static class Worker {
		private int index;
		private int totalWorkTimes;

		public Worker(int index, int totalWorkTimes) {
			this.index = index;
			this.totalWorkTimes = totalWorkTimes;
		}
		
		public void addHours(int hours) {
			totalWorkTimes += hours;
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