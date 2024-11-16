package silver;

import java.util.*;
import java.io.*;

public class PROB11723 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int M;
    static Set<Integer> set = new HashSet<>();

    static final String ADD = "add";
    static final String CHECK = "check";
    static final String REMOVE = "remove";
    static final String TOGGLE = "toggle";
    static final String ALL = "all";
    static final String EMPTY = "empty";

    public static void main(String[] args) throws IOException {
        solve();

        System.out.println(sb);
    }

    public static void solve() throws IOException {
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int temp;

            if (!command.equals(ALL) && !command.equals(EMPTY)) {
                temp = Integer.parseInt(st.nextToken());
                checkCommandAndDo(command, temp);
            } else
                checkCommandAndDo(command, -1);
        }
    }

    public static void checkCommandAndDo(String command, int value) {
        switch(command) {
            case ADD:
                set.add(value);
                return;

            case REMOVE:
                set.remove(value);
                return;

            case CHECK:
                if (set.contains(value))
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
                return;

            case TOGGLE:
                if (!set.contains(value))
                    set.add(value);
                else
                    set.remove(value);
                return;

            case ALL:
                for (int i = 0; i < 20; i++)
                    set.add(i + 1);
                return;

            case EMPTY:
                set.clear();
        }
    }
}
