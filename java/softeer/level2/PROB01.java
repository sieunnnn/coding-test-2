package softeer.level2;

import java.util.*;
import java.io.*;

public class PROB01 {
    // 나무 공격
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int m;
    static int[][] map;
    static Set<Integer> attacks;

    public static void main(String[] args) throws IOException {
        solve();
        find();
    }

    public static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            attacks = new HashSet<>();
            for(int j = start; j <= end; j++)
                attacks.add(j);

            attack(start, end);

            // System.out.println(Arrays.deepToString(map));
        }
    }

    public static void attack(int start, int end) {
        for (int i = 0; i < m; i++) {
            for (int j = start; j <= end; j++) {
                if (map[j][i] == 1) {
                    if (attacks.contains(j)) {
                        attacks.remove(j);
                        map[j][i] = 0;
                    }
                }
            }
        }
    }

    public static void find() {
        int sum = 0;

        for (int[] col : map) {
            for (int row : col) {
                if (row == 1)
                    sum ++;
            }
        }

        System.out.println(sum);
    }
}
