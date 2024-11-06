package bronze;

import java.io.*;
import java.util.*;

public class PROB1546 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static double[] scores;
    static double max = 0;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        scores = new double[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            double temp = Double.parseDouble(st.nextToken());
            scores[i] = temp;
            max = Math.max(max, temp);
        }
    }

    public static void solve() {
        double sum = 0;

        for (int i = 0; i < N; i ++) {
            scores[i] = scores[i] / max * 100;
            sum += scores[i];
        }

        System.out.println(sum / N);
    }
}
