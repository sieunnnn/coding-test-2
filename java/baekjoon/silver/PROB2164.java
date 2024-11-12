package silver;

import java.util.*;
import java.io.*;

public class PROB2164 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static Queue<Integer> cards = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            cards.add(i);
        }
    }

    public static void solve() {
        while(cards.size() > 1) {
            cards.poll();

            if (cards.size() > 1) {
                int pollCard = cards.poll();
                cards.add(pollCard);
            }
        }

        System.out.println(cards.poll());
    }
}
