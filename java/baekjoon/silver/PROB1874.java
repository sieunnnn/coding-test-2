package silver;

import java.io.*;
import java.util.*;

public class PROB1874 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] numbers;
    static Stack<Integer> stack = new Stack<>();

    static final String PUSH = "+";
    static final String POP = "-";
    static final String NO = "NO";


    public static void main(String[] args) throws IOException {
        init();
        String answer = solve();

        System.out.println(answer);
    }

    public static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
    }

    public static String solve() throws IOException {
        int current = 1;

        for (int i = 0; i < n; i++) {
            int target = numbers[i];

            while (current <= target) {
                stack.push(current);
                sb.append(PUSH).append("\n");

                current++;
            }

            if (stack.peek() == target) {
                stack.pop();
                sb.append(POP).append("\n");

            } else
                return NO;
        }

        return sb.toString();
    }
}
