package bronze;

import java.io.*;
import java.util.*;

public class PROB2609 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int a, b;
    static int gcd = 1;
    static int lcm = 1;

    public static void main(String[] args) throws IOException {
        init();
        solve();

        System.out.println(gcd);
        System.out.println(lcm);
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
    }

    public static void solve() {
        int number = 2;

        while(true) {
            if (a < number || b < number) {
                lcm *= a;
                lcm *= b;
                break;
            }

            if (a % number == 0 && b  % number == 0) {
                a = a / number;
                b = b / number;

                gcd *= number;
                lcm *= number;
            } else
                number++;
        }
    }
}
