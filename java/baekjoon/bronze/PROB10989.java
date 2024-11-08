package bronze;

import java.io.*;

public class PROB10989 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static final int MAX = 10000;

    static int N;
    static int[] counts = new int[MAX];

    public static void main(String[] args) throws IOException {
        init();
        solve();

        System.out.println(sb);
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            counts[input - 1] ++;
        }
    }

    public static void solve() {
        for (int i = 0; i < MAX; i++) {
            while (counts[i] > 0) {
                sb.append(i + 1).append("\n");
                counts[i]--;
            }
        }
    }
}
