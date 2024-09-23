import java.io.*;
import java.util.*;

public class Test_File {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int number = reader.nextInt();
        int k = reader.nextInt();
        long[] array = new long[number];
        HashMap<Long, Number> saveIndex = new HashMap<>();
        for(int i = 0; i<number;i++) {
            array[i] = reader.nextLong();
            if(saveIndex.containsKey(array[i])) {
                saveIndex.get(array[i]).addIndex(i);;
            }
            else {
                Number n = new Number(array[i]);
                n.addIndex(i);
                saveIndex.put(array[i], n);
            }
        }
        Arrays.sort(array);
        int count = 0;
        for(int i=0;i<array.length;i++) {
            long found = array[i]+k;
            int index = Arrays.binarySearch(array, found);
            if(index>i) {
                int a = saveIndex.get(array[i]).Check(saveIndex.get(found).getIndex());
                if(a>0) {
                    saveIndex.get(array[i]).RemoveIndex();
                    count+=a;
                }
                
            }
        }
        System.out.println(count);

    }
    static class Number {
        private long nu;
        private ArrayList<Integer> index;
        public Number(long nu) {
            this.nu = nu;
            index = new ArrayList<Integer>();
        }
        public long getNu() {
            return nu;
        }
        public void setNu(long nu) {
            this.nu = nu;
        }
        public ArrayList<Integer> getIndex() {
            return index;
        }
        public void addIndex(int i) {
            index.add(i);
        }
        public int Check(ArrayList<Integer> list) {
            int count = 0;
            for(int e:list) {
                if(e>index.get(0)) {
                    count++;
                    //return true;
                }
            }
            //return false;
            return count;
        }
        public void RemoveIndex() {
                index.remove(0);
            
        }
        
    }
//        int numberOfPeople = reader.nextInt();
//        int numberOfJobs = reader.nextInt();
//        
//        PriorityQueue<Worker> jobs = new PriorityQueue<>((w1,w2)->{
//            int compare = Integer.compare(w1.worktime, w2.worktime);
//            if(compare == 0) {
//                compare = Integer.compare(w1.index, w2.index);
//            }
//            return compare;
//        });
//        
//        List<Integer> listJob = new ArrayList<>();
//        for(int i=0;i<numberOfJobs;i++) {
//            int hours = reader.nextInt();
//            listJob.add(hours);
//        }
//        listJob.sort((o1, o2) -> {
//            int compare = Integer.compare(o2, o1);
//            return compare;
//        });
//        for(int i = 1;i<=numberOfPeople;i++) {
//            Worker worker = new Worker(i, listJob.get(i-1));
//            jobs.add(worker);
//        }
//        for(int i = numberOfPeople;i<listJob.size();i++) {
//            Worker worker = jobs.poll();
//            worker.plusWorkTime(listJob.get(i));
//            jobs.add(worker);
//        }
//        List<Worker> list = new ArrayList<>();
//        for(Worker e:jobs) {
//            list.add(e);
//        }
//        list.sort((o1, o2) -> {
//            int compare = Integer.compare(o1.index, o2.index);
//            return compare;
//        });
//        for(Worker e:list) {
//            sb.append(e.worktime+" ");
//            sb.append("\n");
//        }
//        System.out.println(sb);

//    }
//    static class Worker{
//        private int index;
//        private int worktime;
//
//        public Worker(int index, int worktime) {
//            this.index = index;
//            this.worktime = worktime;
//        }
//        public void plusWorkTime(int hours) {
//            worktime+=hours;
//        }

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
