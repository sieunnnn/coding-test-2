package silver;

import java.util.*;
import java.io.*;

public class PROB15654 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] input;
    static int[] combination;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            input[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(input);
    }

    public static void solve() {
        combination = new int[M];
        visited = new boolean[N];

        dfs(0);

        System.out.print(sb.toString());
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int num : combination)
                sb.append(num).append(" ");

            sb.append("\n");

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                combination[depth] = input[i];
                visited[i] = true;

                dfs(depth + 1);

                visited[i] = false;
            }
        }
    }
}
