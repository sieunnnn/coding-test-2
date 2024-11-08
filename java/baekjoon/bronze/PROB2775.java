package bronze;

import java.io.*;

public class PROB2775 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int T, k, n;
    static int[][] floors;

    static final int HOUSE_NUMBER = 15;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(sb);
    }

    public static void init() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());

            floors = new int[k + 1][HOUSE_NUMBER];
            solve();
        }
    }

    public static void solve() {
        for (int i = 0; i < HOUSE_NUMBER; i++) {
            floors[0][i] = i;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < HOUSE_NUMBER; j++) {
                floors[i][j] = floors[i - 1][j] + floors[i][j - 1];
            }
        }

        sb.append(floors[k][n]).append("\n");
    }
}
