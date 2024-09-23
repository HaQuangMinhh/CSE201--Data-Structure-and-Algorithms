import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EIPICNIC {

	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = reader.nextInt();
		int[] arrCar = new int[] {0 , 0 , 0 , 0 , 0}; // khởi tạo 5 phần tử 
		
		for (int i = 0 ; i < n ; i++) {
			int group = reader.nextInt();
			arrCar[group]++;
		}
		
		int CarNum = 0 ; 
		CarNum += arrCar[4]; // chở tối đa 4 người 
		
		if (arrCar[3] - arrCar[1] >= 0) { // xử lí nhóm xe 3
			CarNum += arrCar[3] ; 
			arrCar[1] = 0 ;
		} else {
			arrCar[1] = arrCar[1] - arrCar[3] ;
			CarNum += arrCar[3];
		}
		
		CarNum += arrCar[2] / 2 ; // xử li nhóm 2 xe 
		if (arrCar[2] % 2 != 0 ) {
			arrCar[2] = 1 ;
		} else 
			arrCar[2] = 0 ; 
		
		CarNum += arrCar[1] / 4; // nhom xe 1 ng
		arrCar[1] = arrCar[1] % 4 ; 
		
		CarNum += ( arrCar[1] + arrCar[2] * 2) / 4 ; // tìm số lượng xe cần thiết
		arrCar[1] = ( arrCar[1] + arrCar[2] * 2 ) % 4 ; 
		if (arrCar[1] != 0 ) {
			CarNum++;
		}
		System.out.println(CarNum);
		
				
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
