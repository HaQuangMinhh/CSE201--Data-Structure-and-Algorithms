import java.io.*;
import java.util.*;

public class EIEXERGRD {
    static InputReader rd = new InputReader(System.in);
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        int stNum = rd.nextInt();
        int problemNum = rd.nextInt();
        int submissionNum = rd.nextInt();

        HashMap<Integer, Student> students = new HashMap<>();
        HashMap<Integer, Integer> weights = new HashMap<>();
        ArrayList<Integer> studentIds = new ArrayList<>();

        for (int i = 0; i < stNum; i++) {
            int studentId = rd.nextInt();
            studentIds.add(studentId);
            students.put(studentId, new Student(studentId, problemNum));
        }

        for (int j = 0; j < problemNum; j++) {
            int problemId = rd.nextInt();
            int weight = rd.nextInt();
            weights.put(problemId, weight);
        }

        for (int k = 0; k < submissionNum; k++) {
            int studentId = rd.nextInt();
            int problemId = rd.nextInt();
            int score = rd.nextInt();

            Student student = students.get(studentId);
            int previousScore = student.scores.getOrDefault(problemId, -1);
            if (score > previousScore) {
                student.setScore(problemId, score);
            }
        }

        for (int id : studentIds) {
            Student student = students.get(id);
            sb.append(student.id).append(" ").append(student.calculateAverage(weights)).append("\n");
        }

        System.out.println(sb);
    }

    static class Student {
        int id;
        Map<Integer, Integer> scores;

        public Student(int id, int problemNum) {
            this.id = id;
            this.scores = new HashMap<>();
        }

        public void setScore(int problemId, int score) {
            scores.put(problemId, score);
        }

        public int calculateAverage(Map<Integer, Integer> weights) {
            int totalScore = 0;
            for (Map.Entry<Integer, Integer> entry : scores.entrySet()) {
                totalScore += entry.getValue() * weights.get(entry.getKey());
            }
            return totalScore / scores.size();
        }
    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}