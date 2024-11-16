package silver;

import java.io.*;

public class PROB1003 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int T;
    static int[][] fibonacci = new int[41][2];

    public static void main(String[] args) throws IOException {
        init();
        solve();

        System.out.println(sb);
    }

    public static void init() {
        fibonacci[0] = new int[]{1, 0};
        fibonacci[1] = new int[]{0, 1};

        for (int i = 2; i < 41; i++) {
            fibonacci[i][0] = fibonacci[i - 1][0] + fibonacci[i - 2][0];
            fibonacci[i][1] = fibonacci[i - 1][1] + fibonacci[i - 2][1];
        }
    }

    public static void solve() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int input = Integer.parseInt(br.readLine());

            sb.append(fibonacci[input][0]).append(" ").append(fibonacci[input][1]).append("\n");
        }
    }
}
