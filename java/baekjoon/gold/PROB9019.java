package gold;

import java.util.*;
import java.io.*;

public class PROB9019 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int MAX = 10000;

    public static void main(String[] args) throws IOException {
        solve();
    }

    static void solve() throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bfs(A, B);
        }

        System.out.println(sb.toString());
    }

    public static void bfs(int A, int B) {
        boolean[] visited = new boolean[MAX];
        Queue<Integer> queue = new LinkedList<>();
        Queue<String> commands = new LinkedList<>();

        queue.add(A);
        commands.add("");

        visited[A] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int next;
            String command = commands.poll();

            if (current == B) {
                sb.append(command).append("\n");
                return;
            }

            next = (current * 2) % MAX;
            if (!visited[next]) {
                visited[next] = true;
                queue.add(next);
                commands.add(command + "D");
            }

            next = (current == 0) ? 9999 : current - 1;
            if (!visited[next]) {
                visited[next] = true;
                queue.add(next);
                commands.add(command + "S");
            }

            next = (current % 1000) * 10 + current / 1000;
            if (!visited[next]) {
                visited[next] = true;
                queue.add(next);
                commands.add(command + "L");
            }

            next = (current / 10) + (current % 10) * 1000;
            if (!visited[next]) {
                visited[next] = true;
                queue.add(next);
                commands.add(command + "R");
            }
        }
    }
}