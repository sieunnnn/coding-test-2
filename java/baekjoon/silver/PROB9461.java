package silver;

import java.util.*;
import java.io.*;

public class PROB9461 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static final int MAX = 101;

    static int T;
    static long[] sequence = new long[MAX];

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    public static void init() {
        sequence[1] = 1;
        sequence[2] = 1;
        sequence[3] = 1;
        sequence[4] = 2;
        sequence[5] = 2;

        for (int i = 6; i < MAX; i++) {
            sequence[i] = sequence[i - 2] + sequence[i - 3];
        }
    }

    public static void solve() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(sequence[N]);
        }
    }
}
