package silver;

import java.util.*;
import java.io.*;

public class PROB11053 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] lengths;
    static int[] memoization;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        lengths = new int[N];
        memoization = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lengths[i] = Integer.parseInt(st.nextToken());
            memoization[i] = 1;
        }
    }

    public static void solve() {
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (lengths[j] < lengths[i]) {
                    memoization[i] = Math.max(memoization[i], memoization[j] + 1);
                }
            }
        }
    }

    public static void print() {
        int max = 0;

        for (int i = 0; i < N; i++)
            max = Math.max(memoization[i], max);

        System.out.println(max);
    }
}
