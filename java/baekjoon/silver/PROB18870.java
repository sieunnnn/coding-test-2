package silver;

import java.io.*;
import java.util.*;

public class PROB18870 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] numbers;
    static int[] sortedNumbers;
    static Map<Integer, Integer> orders = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();
        setOrder();
        solve();

        System.out.println(sb);
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        sortedNumbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        sortedNumbers = Arrays.copyOf(numbers, N);
        Arrays.sort(sortedNumbers);
    }

    public static void setOrder() {
        int order = 0;
        orders.put(sortedNumbers[0], order++);

        for(int i = 1; i < N; i++) {
            if (sortedNumbers[i - 1] != sortedNumbers[i])
                orders.put(sortedNumbers[i], order++);
        }
    }

    public static void solve() {
        for (int i = 0; i < N; i++) {
            int value = orders.get(numbers[i]);

            sb.append(value).append(" ");
        }
    }
}
