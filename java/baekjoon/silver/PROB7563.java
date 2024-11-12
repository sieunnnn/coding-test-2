package silver;

import java.io.*;
import java.util.*;

public class PROB7563 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static List<Student> students;

    static class Student {
        int weight;
        int height;
        int rank;

        Student(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        setRank();
        print();
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            students.add(new Student(weight, height));
        }
    }

    public static void setRank() {
        for (int i = 0; i < students.size(); i++) {
            int rank = 1;
            for (int j = 0; j < students.size(); j++) {
                if (i != j) {
                    if (students.get(j).weight > students.get(i).weight
                    && students.get(j).height > students.get(i).height) {
                        rank++;
                    }
                }
            }
            students.get(i).setRank(rank);
        }
    }

    public static void print() {
        for (Student student : students) {
            sb.append(student.rank).append(" ");
        }
        System.out.println(sb);
    }
}
