package silver;

import java.io.*;

public class PROB11727 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static final int MOD = 10007;
    static final int MAX = 1001;

    static int n;
    static int[] counts = new int[MAX];

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    public static void init() {
        counts[1] = 1;
        counts[2] = 3;

        for (int i = 3; i < MAX; i++)
            counts[i] = (counts[i - 1]  + 2 * counts[i - 2]) % MOD;
    }

    public static void solve() throws IOException {
        n = Integer.parseInt(br.readLine());

        System.out.println(counts[n]);
    }
}
