import java.util.Scanner;

public class EIUPREIU {

    static StringBuilder dash = new StringBuilder();
    static StringBuilder space = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int half = num / 2;

        for (int i = 0; i < half; i++) {
            dash.append("_");
            space.append(" ");
        }
        System.out.println(" " + dash + space + "     ");

        // In phần trên của chữ E ( trước thanh ngang giữa )
        for (  int i = 0 ; i < half - 1 ; i++) {
            System.out.println("|" + space + " | |" + space + "|");
        }

        // In thanh ngang giữa chữ E
        System.out.println("|" + dash + " | |" + space + "|");

        // In phần dưới chữ E:
        for (int i = 0; i < half - 1; i++) {
            System.out.println("|" + space + " | |" + space + "|");
        }

        System.out.print("|" + dash + " | |" + dash + "|\n");
        
    }

}
