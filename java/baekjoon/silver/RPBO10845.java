package silver;

import java.io.*;
import java.util.*;

public class RPBO10845 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int lastNumber = 0;
    static Queue<Integer> queue = new LinkedList<>();

    static final String PUSH = "push";
    static final String POP = "pop";
    static final String SIZE = "size";
    static final String EMPTY = "empty";
    static final String FRONT = "front";
    static final String BACK = "back";
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
                queue.add(X);
                lastNumber = X;
                break;

            case POP:
                if (queue.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(queue.remove()).append("\n");
                break;

            case SIZE:
                sb.append(queue.size()).append("\n");
                break;

            case EMPTY:
                if (queue.isEmpty())
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
                break;

            case FRONT:
                if (queue.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(queue.peek()).append("\n");
                break;

            case BACK:
                if (queue.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(lastNumber).append("\n");
                break;
        }
    }
}
