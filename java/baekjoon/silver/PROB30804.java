package silver;

import java.io.*;
import java.util.*;

public class PROB30804 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] fruits;
    static int max = Integer.MIN_VALUE;
    static Map<Integer, Integer> counts = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();
        solve();

        System.out.println(max);
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        fruits = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            fruits[i] = Integer.parseInt(st.nextToken());
    }

    public static void solve() {
        int start = 0;
        for (int i = 0; i < N; i++) {
            counts.put(fruits[i], counts.getOrDefault(fruits[i], 0) + 1);

            while(counts.size() > 2) {
                counts.put(fruits[start], counts.getOrDefault(fruits[start], 0) - 1);

                if (counts.get(fruits[start]) == 0)
                    counts.remove(fruits[start]);

                start++;
            }
            max = Math.max(max, i - start + 1);
        }
    }
}
