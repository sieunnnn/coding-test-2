package gold;

import java.io.*;

public class PROB9251 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static char[] s1;
    static char[] s2;

    static int s1Length;
    static int s2Length;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    public static void init() throws IOException {
        s1 = br.readLine().toCharArray();
        s2 = br.readLine().toCharArray();

        s1Length = s1.length;
        s2Length = s2.length;

        dp = new int[s1Length + 1][s2Length + 1];
    }

    public static void solve() {
        for (int i = 1; i <= s1Length; i++) {
            for (int j = 1; j <= s2Length; j++) {
                if (s1[i - 1] == s2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

            }
        }

        System.out.println(dp[s1Length][s2Length]);
    }
}
