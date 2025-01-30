package silver;

import java.io.*;
import java.util.*;

public class PROB9465 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T;
    static int N;
    static int[][] stickers;

    public static void main(String[] args) throws IOException {
        solve();
        System.out.println(sb);
    }

    public static void solve() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            stickers = new int[2][N];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++)
                    stickers[j][k] = Integer.parseInt(st.nextToken());
            }

            findMaxValue();
            sb.append("\n");
        }
    }

    public static void findMaxValue() {
        if (N == 1) {
            sb.append(Math.max(stickers[0][0], stickers[1][0]));
            return;
        }

        int[][] dp = new int[2][N];

        dp[0][0] = stickers[0][0];
        dp[1][0] = stickers[1][0];

        dp[0][1] = stickers[0][1] + stickers[1][0];
        dp[1][1] = stickers[1][1] + stickers[0][0];

        for (int i = 2; i < N; i++) {
            dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + stickers[0][i];
            dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + stickers[1][i];
        }

        sb.append(Math.max(dp[0][N - 1], dp[1][N - 1]));
    }
}
