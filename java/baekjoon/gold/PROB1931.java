package gold;

import java.io.*;
import java.util.*;

public class PROB1931 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int count = 0;
    static PriorityQueue<int[]> meetings = new PriorityQueue<>((o1, o2) -> {
        if (o1[1] == o2[1])
            return o1[0] - o2[0];

        return o1[1] - o2[1];
    });

    public static void main(String[] args) throws IOException {
        init();
        solve();

        System.out.println(count);
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings.add(new int[]{start, end});
        }
    }

    public static void solve() {
        int[] current = meetings.poll();
//        System.out.println(Arrays.toString(current));
        int lastEnd = current[1];
        count++;

        while(!meetings.isEmpty()) {
            current = meetings.poll();

            if (current[0] >= lastEnd) {
//                System.out.println(Arrays.toString(current));

                count++;
                lastEnd = current[1];
            }
        }
    }
}
