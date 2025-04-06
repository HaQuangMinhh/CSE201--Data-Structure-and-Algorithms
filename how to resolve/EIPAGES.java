import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EIPAGES {

    static StringBuilder sb = new StringBuilder(); 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    

        int num = sc.nextInt();

        List<Integer> numPages = new ArrayList<>(); 

        for ( int i = 0 ; i < num ; i++ ) {
            var result = sc.nextInt();
            numPages.add(result);
        }

        var result = compressPages(numPages);
        System.out.println(result);

        sc.close();
    }

    public static String compressPages ( List<Integer> pages ) {

        Collections.sort(pages);

        for ( int i = 0 ; i < pages.size() ; i++ ) {
            int start = pages.get(i);  // Trang đầu tiên 
            sb.append(start);

            int end = start ; 

            int count = 0 ; 

            while ( i + 1 < pages.size() && pages.get(i + 1) - pages.get(i) == 1 ) {
                end = pages.get(i + 1);
                count++;
                i++ ; 
            }

            if ( count >= 2 ) {
                sb.append("-").append(end);
            } else if ( count == 1 ) {
                sb.append(" ").append(end);
            }
            sb.append(" ");
        }

        return sb.toString().trim();
    }


}
