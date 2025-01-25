package silver;

import java.util.*;
import java.io.*;

public class PROB18111 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static final int ITEM_IN = 2;
    static final int ITEM_OUT = 1;

    static int N, M, B;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        init();

        int[] result = solve();
        System.out.println(result[0] + " " + result[1]);
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int height = Integer.parseInt(st.nextToken());
                map[i][j] = height;
            }
        }
    }

    public static int[] solve() {
        int minTime = Integer.MAX_VALUE;
        int height = 0;

        for (int i = 0; i <= 256; i++) {
            int time = calculateTime(i);

            if (time != -1) {
                if (time < minTime || (time == minTime && i > height)) {
                    minTime = time;
                    height = i;
                }
            }
        }

        return new int[]{minTime, height};
    }

    private static int calculateTime(int targetHeight) {
        int itemCounts = B;
        int time = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int diff = map[i][j] - targetHeight;

                if (diff > 0) {
                    itemCounts += diff;
                    time += ITEM_IN * diff;

                } else if (diff < 0) {
                    itemCounts -= -diff;
                    time += ITEM_OUT * -diff;
                }
            }
        }

        if (itemCounts < 0)
            time = -1;

        return time;
    }
}
