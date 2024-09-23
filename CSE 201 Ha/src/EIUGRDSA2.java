

import java.io.*;
import java.util.*;

public class EIUGRDSA2 {
    static InputReader rd = new InputReader(System.in);
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        int stNum = rd.nextInt();
        int subjectNum = rd.nextInt();
        int submitNum = rd.nextInt();

        HashMap<Integer, Student> listStudents = new HashMap<>();
        ArrayList<Integer> listCourses = new ArrayList<>();

        for (int i = 0; i < stNum; i++) {
            int ids = rd.nextInt();
            listStudents.put(ids, new Student(ids, subjectNum));
        }

        for (int m = 0; m < subjectNum; m++) {
            listCourses.add(rd.nextInt());
        }

        for (int j = 0; j < submitNum; j++) {
            int id = rd.nextInt();
            int course = rd.nextInt();
            int grade = rd.nextInt();

            Student st = listStudents.get(id);
            if (listCourses.contains(course)) {
                st.setGrade(course, grade);
            }
        }

        ArrayList<Student> listGrade = new ArrayList<>(listStudents.values());

        listGrade.sort((s1, s2) -> {
            int compare = s2.avg - s1.avg;
            if (compare == 0) {
                compare = s1.submit - s2.submit;
                if (compare == 0) {
                    compare = s1.id - s2.id;
                }
            }
            return compare;
        });
        for (Student s : listGrade) {
            sb.append(s.id).append(" ").append(s.avg).append(" ").append(s.submit).append("\n");
        }
        System.out.println(sb);
    }

    static class Student {
        int id;
        int avg;
        int subjectNum;
        int submit;
        int sum;

        HashMap<Integer, Integer> subjectMap = new HashMap<>();

        public Student(int id, int subNum) {
            this.id = id;
            this.subjectNum = subNum;
        }

        public void setGrade(int course, int grade) {
            submit++;
            if (grade > subjectMap.getOrDefault(course, -1)) {
                sum -= subjectMap.getOrDefault(course, 0);
                subjectMap.put(course, grade);
                sum += grade;
            }
            this.avg = sum / subjectNum;

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
