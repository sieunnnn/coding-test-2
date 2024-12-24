package gold;

import java.util.*;
import java.io.*;

public class PROB7569 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dx = {-1, 1, 0, 0, 0, 0};

    static int[][][] tomatoes;
    static int M, N, H;
    static int unRipenedTomatoes = 0;
    static Queue<int[]> nodes = new LinkedList<>();

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
        H = Integer.parseInt(st.nextToken());

        tomatoes = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 0; k < M; k++) {
                    int input = Integer.parseInt(st.nextToken());

                    if (input == 0)
                        unRipenedTomatoes++;

                    else if (input == 1)
                        nodes.add(new int[]{i, j, k, 0});

                    tomatoes[i][j][k] = input;
                }
            }
        }
    }

    public static void solve() {
        int days = bfs();

        if (unRipenedTomatoes > 0)
            System.out.println(-1);
        else
            System.out.println(days);
    }

    public static int bfs() {
        int maxDays = 0;

        while(!nodes.isEmpty()) {
            int[] current = nodes.poll();
            int z = current[0];
            int y = current[1];
            int x = current[2];
            int day = current[3];

            maxDays = Math.max(maxDays, day);

            for (int i = 0; i < 6; i ++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M && nz >= 0 && nz < H) {
                    if (tomatoes[nz][ny][nx] == 0) {
                        tomatoes[nz][ny][nx] = 1;
                        nodes.add(new int[]{nz, ny, nx, day + 1});
                        unRipenedTomatoes--;
                    }
                }
            }
        }

        return maxDays;
    }
}
