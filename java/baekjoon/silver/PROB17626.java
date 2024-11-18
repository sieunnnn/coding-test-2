package silver;

import java.io.*;
import java.util.Arrays;

public class PROB17626 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static final int MAX = 50001;

    static int n;
    static int[] counts = new int[MAX];

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    public static void init() {
        for (int i = 1; i < MAX; i ++) {
            counts[i] = i;

            for (int j = 1; j <= Math.sqrt(i); j++)
                counts[i] = Math.min(counts[i], counts[i - j * j] + 1);
        }

//        System.out.println(Arrays.toString(counts));
    }

    public static void solve() throws IOException {
        n = Integer.parseInt(br.readLine());

        System.out.println(counts[n]);
    }
}
