package gold;

import java.util.*;
import java.io.*;

public class PROB14500 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[][] paper;
    static int max = 0;

    static final int[][][] tetrominoes = {
            // I
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}},

            // O
            {{0, 0}, {0, 1}, {1, 0}, {1, 1}},

            // L
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}},
            {{0, 0}, {0, 1}, {0, 2}, {-1, 2}},
            {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
            {{0, 0}, {1, 0}, {2, 0}, {2, -1}},
            {{0, 0}, {1, 0}, {2, 0}, {0, -1}},
            {{0, 0}, {1, 0}, {2, 0}, {0, 1}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 0}},
            {{0, 0}, {0, 1}, {0, 2}, {-1, 0}},

            // Z
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
            {{0, 0}, {0, 1}, {1, 0}, {1, -1}},
            {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
            {{0, 0}, {1, 0}, {1, -1}, {2, -1}},

            // T
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}},
            {{0, 0}, {0, 1}, {0, 2}, {-1, 1}},
            {{0, 0}, {1, 0}, {2, 0}, {1, 1}},
            {{0, 0}, {1, 0}, {2, 0}, {1, -1}}
    };

    public static void main(String[] args) throws IOException {
        init();
        solve();

        System.out.println(max);
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++)
                paper[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    public static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int[][] tetromino : tetrominoes)
                    max = Math.max(max, calculateSum(i, j, tetromino));
            }
        }
    }

    public static int calculateSum(int y, int x, int[][] tetromino) {
        int sum = 0;

        for (int[] block : tetromino) {
            int ny = y + block[0];
            int nx = x + block[1];

            if (ny < 0 || ny >= N || nx < 0 || nx >= M)
                return 0;

            sum += paper[ny][nx];
        }

        return sum;
    }
}
