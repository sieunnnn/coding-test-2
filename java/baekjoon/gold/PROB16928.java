package gold;

import java.io.*;
import java.util.*;

public class PROB16928 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static Map<Integer, Integer> stairs = new HashMap<>();
    static Map<Integer, Integer> snakes = new HashMap<>();
    static boolean[] visited = new boolean[101];
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        init();
        bfs();

        System.out.println(min);
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            stairs.put(start, end);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            snakes.put(start, end);
        }
    }

    public static void bfs() {
        Queue<int[]> point = new LinkedList<>();
        point.add(new int[]{1, 0}); // current point, count
        visited[1] = true;

        while (!point.isEmpty()) {
            int[] currentPoint = point.poll();
            int current = currentPoint[0];
            int count = currentPoint[1];

            if (current == 100) {
                min = Math.min(min, count);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int newPoint = current + i;

                if (newPoint <= 100 && !visited[newPoint]) {
                    if (stairs.containsKey(newPoint))
                        newPoint = stairs.get(newPoint);

                    else if (snakes.containsKey(newPoint))
                        newPoint = snakes.get(newPoint);

                    point.add(new int[]{newPoint, count + 1});
                    visited[newPoint] = true;
                }
            }
        }
    }
}
