package bronze;

import java.io.*;

public class PROB15829 {
    static BufferedReader br;

    static int N, H;
    static char[] alphabets;
    static int[] numbers;

    static final int r = 31;
    static final int M = 1234567891;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    public static void init() throws IOException {
         br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        alphabets = br.readLine().toCharArray();
        numbers = new int[26];

        for (int i = 0; i < 26; i++) {
            numbers[i] = i + 1;
        }
    }

    public static void solve() {
        long sum = 0;
        long pow = (long) Math.pow(r, 0);

        for (int i = 0; i < N; i++) {
            int index = alphabets[i] - 'a';
            sum += numbers[index] * pow % M;
            pow = pow * r % M;
        }

        sum = sum % M;
        System.out.println(sum);
    }
}
