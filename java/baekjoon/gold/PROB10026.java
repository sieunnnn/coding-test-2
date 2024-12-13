package gold;

import java.util.*;
import java.io.*;

public class PROB10026 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static final int RED = 1;
    static final int BLUE = 2;
    static final int GREEN = 3;

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    static int N;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        init();
        int result = solve();

        changeGraph();
        int blindResult = solve();

        System.out.println(result + " " + blindResult);
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");

            for (int j = 0; j < N; j++) {
                if (input[j].equals("R"))
                    graph[i][j] = RED;

                else if (input[j].equals("B"))
                    graph[i][j] = BLUE;

                else if (input[j].equals("G"))
                    graph[i][j] = GREEN;
            }
        }
    }

    public static int solve() {
        visited = new boolean[N][N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    int target = graph[i][j];
                    bfs(i, j, target);
                    count++;
                }
            }
        }

        return count;
    }

    public static void bfs (int y, int x, int target) {
        Queue<int[]> nodes = new LinkedList<>();
        nodes.add(new int[]{y, x});
        visited[y][x] = true;

        while (!nodes.isEmpty()) {
            int[] current = nodes.poll();
            int currentY = current[0];
            int currentX = current[1];

            for (int i = 0; i < 4; i++) {
                int ny = currentY + dy[i];
                int nx = currentX + dx[i];

                if (ny < N && ny >= 0 && nx < N && nx >= 0) {
                    if (!visited[ny][nx] && graph[ny][nx] == target) {
                        visited[ny][nx] = true;
                        nodes.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }

    public static void changeGraph() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == GREEN)
                    graph[i][j] = RED;
            }
        }
    }
}
