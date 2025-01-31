package silver;

import java.io.*;
import java.util.*;

public class PROB11660 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int M;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        init();
        solve();

        System.out.println(sb);
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++)
                dp[i][j] = Integer.parseInt(st.nextToken()) + dp[i][j - 1];
        }
//        System.out.println(Arrays.deepToString(dp));
    }

    public static void solve() throws IOException {
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int sum = 0;

            for (int j = x1; j <= x2; j++) {
                sum = sum + (dp[j][y2] - dp[j][y1-1]);
            }

            sb.append(sum).append("\n");
        }
    }
}
