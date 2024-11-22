package silver;

import java.util.*;
import java.io.*;

public class PROB1697 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dx = {-1, 1, 2};

    static int N, K;
    static boolean[] visited = new boolean[100001];

    static class Point {
        int point;
        int time;

        public Point(int point, int time) {
            this.point = point;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int answer = bfs(N);
        System.out.println(answer);
    }

    public static int bfs(int start) {
        Queue<Point> point = new LinkedList<>();
        point.add(new Point(start, 0));
        visited[start] = true;

        while(!point.isEmpty()) {
            Point current = point.poll();
            if (current.point == K) {
                return current.time;
            }

            for(int i = 0; i < 3; i++) {
                int newPoint;
                if (i != 2)
                    newPoint = current.point + dx[i];
                else
                    newPoint = current.point * dx[i];

                if (newPoint >= 0 && newPoint <= 100000 && !visited[newPoint]) {
                    visited[newPoint] = true;
                    point.add(new Point(newPoint, current.time + 1));
                }
            }
        }

        return 0;
    }
}
