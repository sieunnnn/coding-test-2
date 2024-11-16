package silver;

import java.io.*;
import java.util.*;

public class PROB1620 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static Map<String, Integer> poketmons = new HashMap<>();
    static Map<Integer, String> indexes = new HashMap<>();

    public static void main(String[] args) throws IOException {
        solve();

        System.out.println(sb);
    }

    public static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            poketmons.put(input, i + 1);
            indexes.put(i + 1, input);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();

            if (input.matches("^[0-9]*$")) {
                String answer = indexes.get(Integer.parseInt(input));
                sb.append(answer).append("\n");

            } else {
                int answer = poketmons.get(input);
                sb.append(answer).append("\n");
            }
        }
    }
}
