import java.util.*;
import java.io.*;

class EIDUPBOD {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        Map<String, Birthday> birthdayMap = new HashMap<>();
        int n = reader.nextInt();
        for (int i = 0; i < n; i++) {

            int day = reader.nextInt();
            int month = reader.nextInt();
            int year = reader.nextInt();
            StringBuilder sb = new StringBuilder();
            if (day < 10) {
                sb.append("0");
            }
            sb.append(day).append("/");

            if (month < 10) {
                sb.append("0");
            }
            sb.append(month).append("/");

            sb.append(year);

            Birthday birthday = birthdayMap.get(sb.toString());

            if (birthday == null) {
                birthday = new Birthday(day, month, year, sb.toString());
                birthdayMap.put(sb.toString(), birthday);
            }
            birthday.count++;
        }
        List<Birthday> birthdays = new ArrayList<>(birthdayMap.values());
        birthdays.sort((b1, b2) -> {
            int compare = b1.year - b2.year;
            if (compare == 0) {
                compare = b1.month - b2.month;
                if (compare == 0) {
                    compare = b1.day - b2.day;
                }
            }
            return compare;
        });

        StringBuilder sb=new StringBuilder();
        for(Birthday b:birthdays){
            sb.append(b.dob).append(" ").append(b.count).append("\n");
        }
        System.out.println(sb);
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

class Birthday {
    int day;
    int month;
    int year;
    String dob;
    int count = 0;

    public Birthday(int day, int month, int year, String b) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.dob = b;
    }

}
