package silver;

import java.util.*;
import java.io.*;

public class PROB16953 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int A, B;

    public static void main(String[] args) throws IOException {
        init();
        int result = bfs();

        System.out.println(result);
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }

    public static int bfs() {
        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{A, 1});

        while (!queue.isEmpty()) {
            long[] current = queue.poll();
            long currentA = current[0];
            long currentCount = current[1];

            if (currentA == B)
                return (int) currentCount;

            if (currentA > B)
                continue;

            queue.add(new long[]{currentA * 2, currentCount + 1});
            queue.add(new long[]{currentA * 10 + 1, currentCount + 1});
        }

        return -1;
    }
}