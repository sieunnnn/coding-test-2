package silver;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class PROB1181 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static List<String> strs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            strs.add(br.readLine());
        }
    }

    public static void solve() {
        strs = strs.stream()
                .sorted((o1, o2) -> {
                    if (o1.length() == o2.length())
                        return  o1.compareTo(o2);

                    return o1.length() - o2.length();
                })
                .distinct()
                .collect(Collectors.toList());
    }

    public static void print() {
        for (String str : strs)
            System.out.println(str);
    }
}
