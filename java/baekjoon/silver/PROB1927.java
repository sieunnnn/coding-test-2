package silver;

import java.util.*;
import java.io.*;

public class PROB1927 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static final int COMMAND = 0;

    static int N;
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        solve();

        System.out.println(sb);
    }

    public static void solve() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == COMMAND) {
                if (minHeap.isEmpty())
                    sb.append(COMMAND).append("\n");
                else
                    sb.append(minHeap.poll()).append("\n");
            } else
                minHeap.add(input);
        }
    }
}
