package silver;

import java.util.*;
import java.io.*;

public class PROB11286 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static PriorityQueue<Integer> numbers = new PriorityQueue<>((o1, o2) -> {
        if (Math.abs(o1) == Math.abs(o2))
            return o1 - o2;
        return Math.abs(o1) - Math.abs(o2);
    });

    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void solve() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                if (numbers.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(numbers.poll());

            } else {
                numbers.add(input);
            }
        }
    }
}
