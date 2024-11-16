package silver;

import java.io.*;

public class PROB1463 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] results;

    public static void main(String[] args) throws IOException {
        int answer = solve();

        System.out.println(answer);
    }

    public static int solve() throws IOException {
        N = Integer.parseInt(br.readLine());
        results = new int[N + 1];

        if (N == 1)
            return 0;

        for (int i = 2; i <= N; i++) {
            results[i] = results[i - 1] + 1;

            if (i % 2 == 0)
                results[i] = Math.min(results[i], results[i / 2] + 1);

            if (i % 3 == 0)
                results[i] = Math.min(results[i], results[i / 3] + 1);
        }

        return results[N];
    }
}
