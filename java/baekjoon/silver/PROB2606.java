package silver;

import java.util.*;
import java.io.*;

public class PROB2606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, T;
    static List<List<Integer>> graph = new ArrayList<>();
    static Set<Integer> computers = new HashSet<>();

    public static void main(String[] args) throws IOException {
        init();
        dfs(1);

        System.out.println(computers.size() - 1);
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }

    public static void dfs(int computerNumber) {
        computers.add(computerNumber);

        for (int v : graph.get(computerNumber)) {
            if (!computers.contains(v)) {
                dfs(v);
            }
        }
    }
}
