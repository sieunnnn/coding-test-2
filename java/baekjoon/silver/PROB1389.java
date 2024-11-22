package silver;

import java.io.*;
import java.util.*;

public class PROB1389 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static List<List<Integer>> graph = new ArrayList<>();
    static int N, M;

    static class Kevin {
        int name;
        int kevinNumber;

        public Kevin(int name, int kevinNumber) {
            this.name = name;
            this.kevinNumber = kevinNumber;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        initGraph();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }

    public static void initGraph() {
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public static void solve() {
        List<Kevin> kevins = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int kevinNumber = bfs(i);
            kevins.add(new Kevin(i, kevinNumber));
        }

        kevins.sort((o1, o2) -> {
            if (o1.kevinNumber == o2.kevinNumber)
                return o1.name - o2.name;
            return o1.kevinNumber - o2.kevinNumber;
        });

        System.out.println(kevins.get(0).name);
    }

    public static int bfs(int start) {
        boolean[] visited = new boolean[N + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        int kevinNumber = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNode = current[0];
            int distance = current[1];

            kevinNumber += distance;

            for (int neighbor : graph.get(currentNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, distance + 1});
                }
            }
        }

        return kevinNumber;
    }
}
