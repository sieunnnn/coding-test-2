package bronze;

import java.io.*;
import java.util.*;

public class PROB2798 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static Integer[] cards;

    public static void main(String[] args) throws IOException {
        init();
        int answer = solve();

        System.out.println(answer);
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cards = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards, (o1, o2) -> o2 - o1);
//        System.out.println(Arrays.toString(cards));
    }

    public static int solve() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int temp = cards[i] + cards[j] + cards[k];
                    if (temp <= M)
                        sum = Math.max(sum, temp);
                }
            }
        }
        return sum;
    }
}
