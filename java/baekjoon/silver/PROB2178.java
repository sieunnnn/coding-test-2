package silver;

import java.util.*;
import java.io.*;

public class PROB2178 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    static int N, M;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        init();
        int result = bfs();

        System.out.println(result);
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");

            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }
    }

    public static int bfs() {
        Queue<int[]> nodes = new LinkedList<>();
        int[] start = {0, 0, 0};

        nodes.add(start);
        visited[start[0]][start[1]] = true;

        while(!nodes.isEmpty()) {
            int[] current = nodes.poll();
            if (current[0] == N -1 && current[1] == M - 1)
                return current[2] + 1;

            for (int i = 0; i < 4; i++) {
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];
                int count = current[2];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (graph[ny][nx] ==1 && !visited[ny][nx]) {
                        nodes.add(new int[]{ny, nx, count + 1});
                        visited[ny][nx] = true;
                    }
                }
            }
        }

        return 0;
    }
}
