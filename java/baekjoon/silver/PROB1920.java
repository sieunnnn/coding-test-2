package silver;

import java.io.*;
import java.util.*;

public class PROB1920 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static HashSet<Integer> set;
    static int[] targets;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            set.add(input);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        targets = new int[M];

        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void solve() {
        for (int i = 0; i < M; i++) {
            if (set.contains(targets[i])) {
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }
        }

        System.out.println(sb);
    }
}