import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class EIDUPBOD {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb  ;

    public static void main(String[] args) {

        int num = sc.nextInt();

        HashMap<String, Date> listOfDate = new HashMap<>();

        for (int i = 0; i < num; i++) {
            sb = new StringBuilder() ; // reset lại 

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

            // Chuyển int sang String
            Date birthday = listOfDate.get(sb.toString());

            if (birthday == null) {
                birthday = new Date(day, month, year, sb.toString());
                listOfDate.put(sb.toString(), birthday);
            }
            birthday.count++;
        }

        List<Date> list = new ArrayList<>(listOfDate.values());
        list.sort( (b1,b2) -> {
            
            if ( b1.year != b2.year ) {
                return b1.year - b2.year ; 
            }

            if ( b1.month != b2.month ) {
                return b1.month - b2.month ; 
            }

            return b1.day - b2.day ; 
        });
        
        for (Date i : list) {
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
