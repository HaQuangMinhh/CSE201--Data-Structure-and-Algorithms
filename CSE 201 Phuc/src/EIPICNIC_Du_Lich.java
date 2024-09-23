import java.util.*;
import java.io.*;

public class EIPICNIC_Du_Lich {

	public static void main(String[] args) {
		int people = reader.nextInt();
		int[] listPeople = new int[5];
		int numberOfCar = 0;
		for (int i = 0; i < people; i++) {
			listPeople[reader.nextInt()]++;
		}
//		for (int i = 1; i < listPeople.length; i++) {
//			System.out.println(listPeople[i]);
//		}

		numberOfCar += listPeople[4];

		if (listPeople[3] < listPeople[1]) {
			numberOfCar += listPeople[3];
			listPeople[1] -= listPeople[3];
		} else {
			numberOfCar += listPeople[3];
			listPeople[1] = 0;
		}

		if (listPeople[2]  % 2 == 0) {
			numberOfCar += listPeople[2] / 2;
			numberOfCar += (double)Math.ceil(listPeople[1] / 4);
		} else {
			numberOfCar += (listPeople[2] / 2) + 1;
            if (listPeople[1] != 0) {
                if (listPeople[1] <= 2) {
                	numberOfCar += 1;
                } else {
                	numberOfCar += (double)Math.ceil( (listPeople[1] - 2) / 4);
                }
            }
		}

		System.out.println(numberOfCar);

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

//class EIPICNIC_Du_Lich_2 {
//
////    public static void main(String[] args) {
////    	
////    }
//        int people = reader.nextInt();
//        int[] listPeople = new int[5];
//        int numberOfCar = 0;
//        for (int i = 0; i < people; i++) {
//            listPeople[reader.nextInt()]++;
//        }
//
//        numberOfCar += listPeople[4];
//
//        if (listPeople[3] <= listPeople[1]) {
//            numberOfCar += listPeople[3];
//            listPeople[1] -= listPeople[3];
//        } else {
//            numberOfCar += listPeople[3];
//            listPeople[1] = 0;
//        }
//
//        if ((listPeople[2] * 2) / 4 == 0) {
//            numberOfCar += Math.ceil((double)listPeople[2] * 2 / 4);
//            
//        } else {
//            if(listPeople[1] >=2){
//                numberOfCar += Math.ceil((double)listPeople[2] * 2 / 4) + 1; 
//             listPeople[1] -= 2; 
//         } else numberOfCar += Math.ceil((double)listPeople[2] * 2 / 4);
//            
//        }
//
//        if (listPeople[1] >= 4) {
//            numberOfCar += Math.ceil((double)listPeople[1] / 4);
//            listPeople[1] -= listPeople[1] % 4;
//        }
//        if (0 < listPeople[1] && listPeople[1] <= 3) {
//            numberOfCar++;
//        }
//
//        System.out.println(numberOfCar);
//
//    }



