package silver;

import java.util.*;
import java.io.*;

public class PROB11399 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] times;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        times = new int[N];

        for (int i = 0; i < N; i++)
            times[i] = Integer.parseInt(st.nextToken());
    }

    public static void solve() {
        Arrays.sort(times);

        int answer = 0;

        for (int i = 0; i < N; i++) {
            int sum = 0;

            for (int j = 0; j <= i; j++)
                sum += times[j];

            answer += sum;
        }

        System.out.println(answer);
    }
}
