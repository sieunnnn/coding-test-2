package silver;

import java.io.*;
import java.util.*;

public class PROB6064 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(findCalendar(M, N, x, y)).append("\n");
        }

        System.out.print(sb);
    }

    public static int findCalendar(int M, int N, int x, int y) {
        int lcm = lcm(M, N);

        while (x <= lcm) {
            if ((x - 1) % N + 1 == y)
                return x;

            x += M;
        }

        return -1;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
}
