package silver;

import java.util.*;
import java.io.*;

public class PROB11724 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void init() {
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        init();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[N + 1];
        int counts = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                counts++;
            }
        }
        System.out.println(counts);
    }

    public static void dfs(int node) {
        visited[node] = true;

        for (int n : graph.get(node)) {
            if (!visited[n])
                dfs(n);
        }
    }
}
