package silver;

import java.io.*;

public class PROB2579 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] steps;
    static int[] scores;

    public static void main(String[] args) throws IOException {
        init();
        solve();

        System.out.println(scores[N]);
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        steps = new int[N + 1];

        for (int i = 1; i <= N; i++)
            steps[i] = Integer.parseInt(br.readLine());
    }

    public static void solve() {
        scores = new int[N + 1];

        scores[1] = steps[1];
        if (N >= 2) scores[2] = steps[1] + steps[2];
        if (N >= 3) scores[3] = Math.max(steps[1] + steps[3], steps[2] + steps[3]);

        if (N >= 4) {
            for (int i = 4; i <= N; i++)
                scores[i] = Math.max(scores[i - 2] + steps[i], scores[i - 3] + steps[i - 1] + steps[i]);
        }
    }
}
