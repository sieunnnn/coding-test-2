package silver;

import java.io.*;
import java.util.*;

public class PROB10816 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static HashMap<Integer, Integer> cards = new HashMap<>();
    static int[] targets;
    static int[] counts;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());

            cards.put(input, cards.getOrDefault(input, 0) + 1);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        targets = new int[M];

        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void solve() {
        counts = new int[M];

        for (int i = 0; i < M; i++) {
            if (cards.get(targets[i]) != null)
                counts[i] = cards.get(targets[i]);
        }
    }

    public static void print() {
        for (int count : counts) {
            System.out.print(count + " ");
        }
    }
}
