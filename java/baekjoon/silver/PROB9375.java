package silver;

import java.util.*;
import java.io.*;

public class PROB9375 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T;
    static Map<String, Integer> types;

    public static void main(String[] args) throws IOException {
        init();
    }

    public static void init() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            types = new HashMap<>();

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();

                types.put(type, types.getOrDefault(type, 0) + 1);
            }
            solve();
        }
    }

    public static void solve() {
        int multiply = 1;

        for (String key : types.keySet()) {
            multiply *= types.get(key) + 1;
        }

        System.out.println(multiply - 1);
    }
}
