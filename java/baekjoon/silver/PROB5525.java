package silver;

import java.io.*;

public class PROB5525 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static String str;
    static String pn;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solve());
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        str = br.readLine();
        pn = setPn(N);
    }

    public static String setPn(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("I");

        for (int i = 0; i < n; i++) {
            sb.append("O").append("I");
        }

        return sb.toString();
    }

    public static int solve() {
        int count = 0;
        int pnLength = pn.length();

        for (int i = 0; i <= M - pnLength; i++) {
            if (str.substring(i, i + pnLength).equals(pn)) {
                count++;
            }
        }

        return count;
    }
}
