package silver;

import java.util.*;
import java.io.*;

public class PROB14940 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int[] startNode = new int[2];

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());

                if(input == 1)
                    graph[i][j] = -1;
                else {
                    if (input == 2) {
                        startNode[0] = i;
                        startNode[1] = j;
                    }
                    graph[i][j] = input;
                }
            }
        }
    }

    public static void solve() {
        bfs(startNode[0], startNode[1]);
    }

    public static void bfs(int y, int x) {
        Queue<int[]> nodes = new LinkedList<>();
        visited = new boolean[n][m];

        nodes.add(new int[]{y, x, 0});
        visited[y][x] = true;
        graph[y][x] = 0;

        while(!nodes.isEmpty()) {
            int[] node = nodes.poll();
            int currentY = node[0];
            int currentX = node[1];

            graph[currentY][currentX] = node[2];

            for (int i = 0; i < 4; i++) {
                int ny = currentY + dy[i];
                int nx = currentX + dx[i];
                int distance = node[2] + 1;

                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (graph[ny][nx] == -1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        nodes.add(new int[]{ny, nx, distance});
                    }
                }
            }
        }
    }

    public static void print() {
        for (int[] y : graph) {
            for (int x : y) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
