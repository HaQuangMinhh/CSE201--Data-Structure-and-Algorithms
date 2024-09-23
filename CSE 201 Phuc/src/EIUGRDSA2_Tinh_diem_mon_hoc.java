import java.util.*;
import java.io.*;
//chua xog 80đ
public class EIUGRDSA2_Tinh_diem_mon_hoc {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        int totalOfStudents = reader.nextInt();
        int totalOfProblems = reader.nextInt();
        int totalOfSubmission = reader.nextInt();
        Map<Integer, Student> listOfStudent = new HashMap<Integer, Student>();

        for (int i = 0; i < totalOfStudents; i++) {
            int id = reader.nextInt();
            Student stu = new Student(id, totalOfProblems);
            listOfStudent.put(id, stu);
        }

        Map<Integer, Integer> listCodeProblems = new HashMap<Integer, Integer>();
        for (int i = 0; i < totalOfProblems; i++) {
            int codeExercise = reader.nextInt();
            listCodeProblems.put(codeExercise, 1);
        }

        for (int i = 0; i < totalOfSubmission; i++) {
            int id = reader.nextInt();
            int codeExercise = reader.nextInt();
            int score = reader.nextInt();
            if (listCodeProblems.get(codeExercise) != null) {
                listOfStudent.get(id).addGrade(codeExercise, score);
            } 
        }
        List<Student> students = new ArrayList<>(listOfStudent.values());

        students.sort((s1, s2) -> {
            int compare = Double.compare(s2.avg, s1.avg);
            if (compare == 0) {
                compare = Integer.compare(s1.totalOfSubmissions, s2.totalOfSubmissions);
                if (compare == 0) {
                    compare = Integer.compare(s1.id, s2.id);
                }
            }
            return compare;
        });

        for (Student i : students) {
            sb.append(i.id + " " + (int) i.avg + " " + i.totalOfSubmissions + "\n");
        }
        System.out.println(sb);

    }

    static class Student {
        private int id;
        private long totalOfGrade;
        private int totalOfProblems;
        private int totalOfSubmissions;
        private double avg;
        private HashMap<Integer, Integer> grades;

        public Student(int id, int totalOfProblems) {
            this.id = id;
            this.totalOfProblems = totalOfProblems;
            grades = new HashMap<Integer, Integer>();
        }

        public void addGrade(int codeExercise, int grade) {
            int newGrade = grade;
            if (grades.get(codeExercise) == null) {
                grades.put(codeExercise, grade);
                totalOfGrade += grade;
            } else {
                int oldGrade = grades.get(codeExercise);
                grades.put(codeExercise, (Math.max(grades.get(codeExercise), grade)));
                if (oldGrade < newGrade) {
                    totalOfGrade += newGrade - oldGrade;
                }
            }
            avg = totalOfGrade / totalOfProblems;
            totalOfSubmissions++;

        }
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