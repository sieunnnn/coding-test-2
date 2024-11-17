package silver;

import java.io.*;

public class PROB9095 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int T;
    static int[] counts = new int[12];

    public static void main(String[] args) throws IOException {
        init();
        solve();

        System.out.println(sb);
    }

    public static void init() {
        counts[1] = 1;
        counts[2] = 2;
        counts[3] = 4;

        for (int i = 4; i < 12; i++) {
            counts[i] = counts[i -1] + counts[i - 2] + counts[i - 3];
        }

//        System.out.println(Arrays.toString(counts));
    }

    public static void solve() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int input = Integer.parseInt(br.readLine());
            sb.append(counts[input]).append("\n");
        }
    }
}
