package silver;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class PROB1764 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static Set<String> unheard = new HashSet<>();
    static List<String> names = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        sort();
        print();
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            unheard.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();

            if (unheard.contains(input))
                names.add(input);
        }
    }

    public static void sort() {
        names = names.stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    public static void print() {
        System.out.println(names.size());

        for (String name : names)
            System.out.println(name);
    }
}
