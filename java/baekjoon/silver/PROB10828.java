package silver;

import java.io.*;
import java.util.*;

public class PROB10828 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Stack<Integer> stack = new Stack<>();

    static final String PUSH = "push";
    static final String POP = "pop";
    static final String SIZE = "size";
    static final String EMPTY = "empty";
    static final String TOP = "top";
    static final int NONE = -1;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(sb);
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String commander = st.nextToken();
            int X =  commander.equals(PUSH) ? Integer.parseInt(st.nextToken()) : NONE;
            solve(commander, X);
        }
    }

    public static void solve(String commander, int X) {
        switch (commander) {
            case PUSH:
                stack.push(X);
                break;

            case POP:
                if (stack.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(stack.pop()).append("\n");
                break;

            case SIZE:
                sb.append(stack.size()).append("\n");
                break;

            case EMPTY:
                if (stack.isEmpty())
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
                break;

            case TOP:
                if (stack.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(stack.peek()).append("\n");
                break;
        }
    }
}
