package silver;

import java.util.*;
import java.io.*;

public class PROB2667 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static List<Integer> apartments = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");

            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(temp[j]);
            }
        }
    }

    public static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    int count = bfs(i, j);
                    apartments.add(count);
                }
            }
        }
    }

    public static int bfs(int y, int x) {
        Queue<int[]> houses = new LinkedList<>();
        houses.add(new int[]{y, x});
        visited[y][x] = true;
        int count = 1;

        while (!houses.isEmpty()) {
            int[] current = houses.poll();

            for (int k = 0; k < 4; k++) {
                int ny = current[0] + dy[k];
                int nx = current[1] + dx[k];

                if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                    if (graph[ny][nx] == 1 && !visited[ny][nx]) {
                        houses.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void print() {
        Collections.sort(apartments);
        System.out.println(apartments.size());

        for (int count : apartments) {
            System.out.println(count);
        }
    }
}
