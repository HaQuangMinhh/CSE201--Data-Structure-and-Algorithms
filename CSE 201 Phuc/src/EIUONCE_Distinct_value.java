import java.util.*;
import java.io.*;

public class EIUONCE_Distinct_value {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int cases = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		for(int c = 0; c<cases;c++) {
			sb = new StringBuilder();
			arr = new ArrayList<>();
			int listNum = sc.nextInt();
			for (int i = 0; i < listNum; i++) {
				arr.add(sc.nextInt());
				
			}
			Collections.sort(arr);
			for(int i = 0 ;i< arr.size(); i++) {
				if(countNum(arr.get(i), arr) == 1) {
					sb.append(arr.get(i) + " ");			
				}
			}
			
			System.out.println(sb);
		}
		

	}
	static int countNum(int num, List<Integer> arr) {
		int count = 0;
		for(int i:arr) {
			if(i == num) {
				count++;
			}
		}
		return count;
	}

}
