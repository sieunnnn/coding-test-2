package silver;

import java.util.*;
import java.io.*;

public class PROB1012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T;
    static int N, M, K; // y, x, count
    static int counts = 0;
    static int[][] graph;
    static boolean[][] visited;

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    static class Coordinate {
        int y;
        int x;

        Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
    }

    public static void init() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph= new int[M][N];
            visited = new boolean[M][N];
            counts = 0;

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                graph[y][x] = 1;

            }
            solve();

            System.out.println(counts);
        }
    }

    public static void solve() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    counts++;
                }
            }
        }
    }

    public static void bfs(int y, int x) {
        Queue<Coordinate> nodes = new LinkedList<>();
        nodes.add(new Coordinate(y, x));
        visited[y][x] = true;

        while (!nodes.isEmpty()) {
            Coordinate currentNode = nodes.poll();
            int currentY = currentNode.y;
            int currentX = currentNode.x;

            for (int i = 0; i < 4; i++) {
                int nextY = currentY + dy[i];
                int nextX = currentX + dx[i];

                if (nextY >= 0 && nextY < M && nextX >= 0 && nextX < N && graph[nextY][nextX] == 1) {
                    if (!visited[nextY][nextX]) {
                        visited[nextY][nextX] = true;
                        nodes.add(new Coordinate(nextY, nextX));
                    }
                }
            }
        }
    }
}
