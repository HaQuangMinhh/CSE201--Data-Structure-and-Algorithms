import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class EITASKDIS {

	static StringBuilder sb = new StringBuilder();
	static InputReader reader = new InputReader(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = reader.nextInt(); // số lượng công nhân 
		int m = reader.nextInt(); // công việc
		
		int[] times = new int[m];
		for (int i = 0 ; i < m ; i++) {
			times[i] = reader.nextInt();
		}
		
		Arrays.sort(times);
		reverse(times);
		
		List<Worker> workers = new ArrayList<>();
		for (int i = 0 ; i < n ; i++) {
			workers.add(new Worker(i));
		}
		
		PriorityQueue<Worker> workerQueue = new PriorityQueue<>( (w1,w2) -> {
			int compare = Integer.compare(w1.totalWorkTime, w2.totalWorkTime);
			if ( compare == 0 ) 
				return Integer.compare(w1.index, w2.index);
			return compare ; 
		});
		workerQueue.addAll(workers);
		
		for (int time : times) {
			Worker minworker = workerQueue.poll(); // làm việc ít nhất từ hàng đợi 
			minworker.totalWorkTime += time ;
			workerQueue.add(minworker);
		}
		
		for (Worker worker : workers) {
			sb.append(worker.totalWorkTime).append(" ");
			
		}
		System.out.println(sb);
	}
	public static class Worker {
		public Worker(int index) {
			super();
			this.index = index;
			this.totalWorkTime =  0;
		}
		int index ; 
		int totalWorkTime ; 
		
		
	}
	
	public static void reverse(int[] array) {
		int n = array.length ; // độ dài mảng 
		
		for (int i = 0 ; i < n / 2 ; i++) {
			int temp = array[i];
			array[i] = array[n - i - 1];
			array[n - i - 1] = temp; 
			
		}
		
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
