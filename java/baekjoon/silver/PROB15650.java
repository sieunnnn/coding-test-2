package silver;

import java.util.*;
import java.io.*;

public class PROB15650 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] combination;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }

    public static void solve() {
        combination = new int[M];
        dfs(1, 0);
        System.out.print(sb.toString());
    }

    public static void dfs(int start, int depth) {
        if (depth == M) {
            for (int num : combination)
                sb.append(num).append(" ");

            sb.append("\n");

            return;
        }

        for (int i = start; i <= N; i++) {
            combination[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
