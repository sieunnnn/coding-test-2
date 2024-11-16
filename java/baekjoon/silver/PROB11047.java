package silver;

import java.util.*;
import java.io.*;

public class PROB11047 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int[] coins;
    static long count;

    public static void main(String[] args) throws IOException {
        init();
        solve();

        System.out.println(count);
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coins = new int[N];

        for (int i = 0; i < N; i++)
            coins[i] = Integer.parseInt(br.readLine());
    }

    public static void solve() throws IOException {
        int lastId = N -1;
        int current = K;

        for (int i = lastId; i >= 0; i--) {
            if (coins[i] <= current) {
                count += current / coins[i];
                current %= coins[i];
            }
        }
    }
}
