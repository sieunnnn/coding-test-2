package silver;

import java.io.*;
import java.util.*;

public class PROB11866 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static Deque<Integer> numbers = new ArrayDeque<>();


    public static void main(String[] args) throws IOException {
        init();
        solve();

        System.out.println(sb);
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            numbers.add(i + 1);
        }
    }

    public static void solve() {
        sb.append("<");

        while (numbers.size() > 1) {
            for (int i = 0; i < K - 1; i ++) {
                int temp = numbers.removeFirst();
                numbers.offerLast(temp);
            }

            int temp = numbers.removeFirst();
            sb.append(temp).append(", ");
//            System.out.println(temp);
        }

        int temp = numbers.removeFirst();
        sb.append(temp).append(">");
    }
}
