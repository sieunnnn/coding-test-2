package bronze;

import java.io.*;
import java.util.*;

public class PROB2869 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int A, B, V;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
    }

    public static void solve() {
        int remainder = (V - B) % (A - B);
        int days = (V - B) / (A - B);

        if (remainder > 0) days ++;

        System.out.println(days);
    }
}
