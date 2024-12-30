package silver;

import java.util.*;
import java.io.*;

public class PROB15663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] numbers;
    static int[] sequence;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        sequence = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(numbers);
    }

    public static void solve() throws IOException {
        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int number : sequence)
                sb.append(number).append(" ");
            sb.append("\n");
            return;
        }

        int prev = -1;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && numbers[i] != prev) {
                visited[i] = true;
                sequence[depth] = numbers[i];
                prev = numbers[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
