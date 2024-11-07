package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PROB2231 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String N;

    public static void main(String[] args) throws IOException {
        N = br.readLine();
        int answer = solve();

        System.out.println(answer);
    }

    public static int solve() {
        int n = Integer.parseInt(N);
        int size = N.length();

        for (int current = Math.max(1, n - size * 9); current <= n; current++) {
            int result = calculate(current, size);
            if (result == n)
                return current;
        }

        return 0;
    }

    public static int calculate(int N, int count) {
        int quotient = N;
        int result = N;

        for (int i = 0; i < count; i++) {
            int remainder = quotient % 10;
            quotient = quotient / 10;
            result += remainder;
        }
        return result;
    }
}
