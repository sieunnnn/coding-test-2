package baekjoon.gold;

import java.util.*;
import java.io.*;

public class PROB2096 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static final int START_ID = 0;
    static final int LAST_ID = 2;

    static int N;
    static int[][] map;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][3];
        dp = new int[N + 1][3][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int j = 0; j < 3; j++) {
            dp[1][j][0] = map[1][j];
            dp[1][j][1] = map[1][j];
        }
    }

    public static void solve() {
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == START_ID) {
                    dp[i][j][0] = map[i][j] + Math.max(dp[i - 1][j][0], dp[i - 1][j + 1][0]);
                    dp[i][j][1] = map[i][j] + Math.min(dp[i - 1][j][1], dp[i - 1][j + 1][1]);

                } else if (j == LAST_ID) {
                    dp[i][j][0] = map[i][j] + Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][0]);
                    dp[i][j][1] = map[i][j] + Math.min(dp[i - 1][j][1], dp[i - 1][j - 1][1]);

                } else {
                    dp[i][j][0] = map[i][j] + Math.max(dp[i - 1][j + 1][0], Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][0]));
                    dp[i][j][1] = map[i][j] + Math.min(dp[i - 1][j + 1][1], Math.min(dp[i - 1][j][1], dp[i - 1][j - 1][1]));
                }
            }
        }

        int max = Math.max(dp[N][0][0], Math.max(dp[N][1][0], dp[N][2][0]));
        int min = Math.min(dp[N][0][1], Math.min(dp[N][1][1], dp[N][2][1]));

        System.out.println(max + " " + min);
    }
}