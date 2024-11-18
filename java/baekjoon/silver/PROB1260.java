package silver;

import java.util.*;
import java.io.*;

public class PROB1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;
    static List<List<Integer>> graph = new ArrayList<>();
    static Queue<Integer> nodes = new LinkedList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        solve();

        System.out.println(sb);
    }

    public static void init() throws IOException {
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        init();
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(V);

        sb.append("\n");

        visited = new boolean[N + 1];

        bfs(V);
    }

    public static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");

        for (int value : graph.get(node)) {
            if (!visited[value]) {
                dfs(value);
            }
        }
    }

    public static void bfs(int node) {
        nodes.add(node);
        visited[node] = true;

        while (!nodes.isEmpty()) {
            int current = nodes.poll();
            sb.append(current).append(" ");

            for (int value : graph.get(current)) {
                if (!visited[value]) {
                    visited[value] = true;
                    nodes.add(value);
                }
            }
        }
    }
}
