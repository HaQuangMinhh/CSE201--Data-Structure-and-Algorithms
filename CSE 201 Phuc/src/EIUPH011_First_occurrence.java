import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class EIUPH011_First_occurrence {

    public static void main(String[] args) {
        StringBuilder sb=  new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < cases; i++) {
            int num = sc.nextInt();
            
            if(map.containsKey(num)) {
                map.put(num, false);              
            } else {
                map.put(num, true);
                sb.append( num + " ");
            }
        }  
        System.out.println(sb);
    }
    
    
    public static void Cach2(int a) {
    	Scanner sc = new Scanner(System.in);
    	int cases = sc.nextInt();
    	int[] arr =  new int [10000];
    	for(int i=0; i<cases; i++) {
    		int num = sc.nextInt();
    		if(arr[num] == 0) {
    			System.out.println(num);
    			arr[num]++;
    		}
    	}
    }

}
