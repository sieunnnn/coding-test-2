package silver;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class PROB1966 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N, M;
    static List<Integer> orders;
    static Deque<document> documents;

    static class document {
        int importance;
        int index;

        document(int importance, int index) {
            this.importance = importance;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
    }

    public static void init() throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            orders = new ArrayList<>();
            documents = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int input = Integer.parseInt(st.nextToken());

                orders.add(input);
                documents.addLast(new document(input, i));
            }

            orders = orders.stream()
                    .sorted(((o1, o2) -> o2 - o1))
                    .collect(Collectors.toList());

            solve();
        }
    }

    public static void solve() {
        int id = 0;
        int count = 1;

        while(true) {
            document current = documents.removeFirst();

            if (current.importance == orders.get(id)) {
                if (current.index == M)
                    break;

                count++;
                id++;
            } else
                documents.addLast(current);
        }

        System.out.println(count);
    }
}
