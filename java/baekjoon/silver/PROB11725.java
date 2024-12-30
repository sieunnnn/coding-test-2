package silver;

import java.util.*;
import java.io.*;

public class PROB11725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];

        for (int i = 0; i <= N; i++)
            nodes.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodes.get(u).add(v);
            nodes.get(v).add(u);
        }
    }

    public static void solve() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        visited = new boolean[N + 1];
        visited[1] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for (int node : nodes.get(current)) {
                if (!visited[node]) {
                    visited[node] = true;
                    parents[node] = current;
                    queue.add(node);
                }
            }
        }
    }

    public static void print() {
        for (int i = 2; i < parents.length; i++)
            System.out.println(parents[i]);
    }
}
