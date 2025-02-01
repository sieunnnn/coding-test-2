package baekjoon.gold;

import java.util.*;
import java.io.*;

public class PROB1916 {
    static class Path {
        int start;
        int end;
        int cost;

        Path(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static ArrayList<ArrayList<Path>> paths;
    static int[] cost;
    static boolean[] visited;
    static int startCity;
    static int endCity;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.println(cost[endCity]);
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        paths = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            paths.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            paths.get(start).add(new Path(start, end, cost));
        }

        st = new StringTokenizer(br.readLine());
        startCity = Integer.parseInt(st.nextToken()) - 1;
        endCity = Integer.parseInt(st.nextToken()) - 1;

        cost = new int[N];
        visited = new boolean[N];

        Arrays.fill(cost, Integer.MAX_VALUE);
    }

    public static void solve() {
        cost[startCity] = 0;

        for (int i = 0; i < N; i++) {
            int cur = -1;
            int minCost = Integer.MAX_VALUE;

            for (int j = 0; j < N; j++) {
                if (!visited[j] && cost[j] < minCost) {
                    minCost = cost[j];
                    cur = j;
                }
            }

            if (cur == -1) break;

            visited[cur] = true;

            for (Path p : paths.get(cur)) {
                if (!visited[p.end] && cost[p.end] > cost[cur] + p.cost)
                    cost[p.end] = cost[cur] + p.cost;
            }
        }
    }
}