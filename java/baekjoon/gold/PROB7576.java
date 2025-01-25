package gold;

import java.util.*;
import java.io.*;

public class PROB7576 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    static int[][] tomatoes;
    static int M, N;
    static Queue<int[]> nodes = new LinkedList<>();
    static int unRipenedTomatoes = 0;
    static int days;

    public static void main(String[] args) throws IOException {
        init();

        if (unRipenedTomatoes == 0)
            System.out.println(0);
        else
            solve();
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomatoes = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());

                if (input == 0)
                    unRipenedTomatoes++;

                else if (input == 1)
                    nodes.add(new int[]{i, j, 0});

                tomatoes[i][j] = input;
            }
        }
    }

    public static void solve() {
        days = bfs();

        if (unRipenedTomatoes > 0)
            System.out.println(-1);
        else
            System.out.println(days);
    }

    public static int bfs() {
        int maxDays = 0;

        while(!nodes.isEmpty()) {
            int[] current = nodes.poll();
            int y = current[0];
            int x = current[1];
            int day = current[2];

            maxDays = Math.max(maxDays, day);

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (tomatoes[ny][nx] == 0) {
                        tomatoes[ny][nx] = 1;
                        nodes.add(new int[]{ny, nx, day + 1});
                        unRipenedTomatoes--;
                    }
                }
            }
        }

        return maxDays;
    }
}
