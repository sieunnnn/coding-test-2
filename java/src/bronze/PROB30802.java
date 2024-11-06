package bronze;

import java.util.*;
import java.io.*;

public class PROB30802 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int T_SIZE = 6;
    static int N;
    static  int T;
    static int P;
    static String line;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        init();
        calculateTShirtsQuantity();
        calculatePenQuantity();

        System.out.println(sb.toString());
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[T_SIZE];

        line = br.readLine();
        st = new StringTokenizer(line);

        for (int i = 0; i < T_SIZE; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        line = br.readLine();
        st = new StringTokenizer(line);
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
    }

    public static void calculateTShirtsQuantity() {
        int sum = 0;
        for (int i = 0; i < T_SIZE; i++) {
            int temp = numbers[i] % T;

            if (temp != 0)
                sum += (numbers[i] / T) + 1;
            else
                sum += (numbers[i] / T);
        }

        sb.append(sum).append("\n");
    }

    public static void calculatePenQuantity() {
        int set = N / P;
        int individual = N % P;

        sb.append(set).append(" ").append(individual);
    }
}
