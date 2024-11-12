package silver;

import java.io.*;

public class PROB2839 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;

    public static void main(String[] args) throws IOException {
        int answer = solve();

        System.out.println(answer);
    }

    public static int solve() throws IOException {
        N = Integer.parseInt(br.readLine());
        int count = 0;

        while (N >= 0) {
            if (N % 5 == 0) {
                count += N / 5;

                return count;
            }

            N -= 3;
            count++;
        }

        return -1;
    }
}
