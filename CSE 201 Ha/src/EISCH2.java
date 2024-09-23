import java.io.*;
import java.util.*;
 class EISCH2 {
    static InputReader rd = new InputReader(System.in);
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) {
        int studentNum = rd.nextInt();

        ArrayList<Student> listStudents = new ArrayList<>();

        for (int i = 0; i < studentNum; i++) {
            String name = rd.next();
            int courseNum = rd.nextInt();
            int passed = 0;
            double avg = 0;

            for (int j = 0; j < courseNum; j++) {
                int grade = rd.nextInt();

                if (grade > 49) {
                    avg += grade;
                    passed++;
                }
            }
            if (avg != 0) {
                avg /= passed;
            }
            listStudents.add(new Student(name, avg));
        }

        listStudents.sort((s1, s2) -> {
            int compare = Double.compare(s2.avg, s1.avg);
            if (compare == 0) {
                compare = s1.name.compareTo(s2.name);
            }
            return compare;
        });

        int scholarshipA = studentNum / 12;
        int scholarshipB = studentNum / 3;
        int scholarshipc = studentNum / 2;

        String type = "A";
        for (int s = 0; s < studentNum/2; s++) {
            Student st = listStudents.get(s);

            if (type == "A") {
                if (Double.compare(st.avg, listStudents.get(studentNum / 12).avg) == 0||scholarshipA==0) {
                    type = "B";
                }else {
                    scholarshipA--;
                    scholarshipB--;
                    scholarshipc--;
                }
            }
            
            if(type =="B") {
                if (Double.compare(st.avg, listStudents.get(studentNum / 3).avg) == 0||scholarshipB==0) {
                    type = "C";
                }else {
                    scholarshipB--;
                    scholarshipc--;
                }
            }
            
            if(type =="C") {
                if (Double.compare(st.avg, listStudents.get(studentNum / 2).avg) == 0) {
                    break;
                }
            }
            
            sb.append(st.name).append(" ").append(st.avg).append(" ").append(type).append("\n");
        }
        System.out.println(sb);
    }
    static class Student {
        String name;
        double avg = 0;
    
        public Student(String name, double avg) {
            this.name = name;
            this.avg = avg;
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

