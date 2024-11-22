package silver;

import java.util.*;
import java.io.*;

public class PROB21736 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static final String P = "P";
    static final String X = "X";
    static final String I = "I";
    static final String NONE = "TT";

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    static int N; // y
    static int M; // x
    static String[][] graph;
    static boolean[][] visited;
    static int[] startPoint = new int[2];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        print();
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new String[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");

            for (int j = 0; j < M; j++) {
                String input = temp[j];

                if (input.equals(I)) {
                    startPoint[0] = i;
                    startPoint[1] = j;
                }

                graph[i][j] = temp[j];
            }
        }

//        System.out.println(Arrays.deepToString(graph));
    }

    public static void bfs() {
        Queue<int[]> nodes = new LinkedList<>();
        nodes.add(startPoint);
        visited[startPoint[0]][startPoint[1]] = true;

        while (!nodes.isEmpty()) {
            int[] current = nodes.poll();
            int y = current[0];
            int x = current[1];

            if (graph[y][x].equals(P)) count++;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < N && nx >=0 && nx < M) {
                    if (!graph[ny][nx].equals(X) && !visited[ny][nx]) {
                        nodes.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }

    public static void print() {
        if (count == 0)
            System.out.println(NONE);
        else
            System.out.println(count);
    }
}
