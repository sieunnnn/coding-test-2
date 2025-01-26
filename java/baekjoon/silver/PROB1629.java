package silver;

import java.io.*;
import java.util.*;

public class PROB1629 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static long A, B, C;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(pow(A, B, C));
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
    }

    public static long pow(long base, long exp, long mod) {
        if (exp == 0)
            return 1;

        if (exp == 1)
            return base % mod;

        long half = pow(base, exp / 2, mod);
        long result = (half * half) % mod;

        if (exp % 2 == 1)
            result = (result * base) % mod;

        return result;
    }
}
