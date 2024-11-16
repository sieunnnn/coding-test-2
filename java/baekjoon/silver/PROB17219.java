package silver;

import java.util.*;
import java.io.*;

public class PROB17219 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static Map<String, String> infos = new HashMap<>();

    public static void main(String[] args) throws IOException {
        solve();

        System.out.println(sb);
    }

    public static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String homePage = st.nextToken();
            String password = st.nextToken();

            infos.put(homePage, password);
        }

        for (int i = 0; i < M; i++) {
            String homepage = br.readLine();

            if (infos.containsKey(homepage))
                sb.append(infos.get(homepage)).append("\n");
        }
    }
}
