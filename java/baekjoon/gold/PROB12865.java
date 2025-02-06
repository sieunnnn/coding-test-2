package gold;

import java.io.*;
import java.util.*;

public class PROB12865 {
    static class thing {
        int weight;
        int values;

        thing(int weight, int values) {
            this.weight = weight;
            this.values = values;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int[][] dp;
    static thing[] things;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][K + 1];
        things = new thing[K + 1];


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            things[i] = new thing(weight, value);
        }
    }

    public static void solve() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                thing current = things[i];

                if (current.weight > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - current.weight] + current.values);
            }
        }
        System.out.println(dp[N][K]);
    }
}
