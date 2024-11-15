package silver;

import java.io.*;
import java.util.*;

public class PROB1929 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        init();
        find();
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        isPrime = new boolean[N + 1];
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static void find() {
        for (int i = M; i <= N; i++) {
            if (isPrime[i])
                System.out.println(i);
        }
    }
}
