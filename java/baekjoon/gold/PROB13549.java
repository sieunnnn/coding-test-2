package gold;

import java.util.*;
import java.io.*;

public class PROB13549 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static final int MAX = 100000;

    static int N, K;
    static int time = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[MAX + 1];

    public static void main(String[] args) throws IOException {
        init();
        solve();

        System.out.println(time);
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    public static void solve() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currPosition = current[0];
            int currTime = current[1];

            if (currPosition == K) {
                time = Math.min(currTime, time);
                return;
            }

            int moveLeft = currPosition - 1;
            int moveRight = currPosition + 1;
            int moveFast = currPosition * 2;

            if (!checkPosition(moveFast)) {
                queue.add(new int[]{moveFast, currTime});
                visited[moveFast] = true;
            }

            if (!checkPosition(moveLeft)) {
                queue.add(new int[]{moveLeft, currTime + 1});
                visited[moveLeft] = true;
            }

            if (!checkPosition(moveRight)) {
                queue.add(new int[]{moveRight, currTime + 1});
                visited[moveRight] = true;
            }
        }
    }

    public static boolean checkPosition(int position) {
        return position < 0 || position > 100000 || visited[position];
    }
}
