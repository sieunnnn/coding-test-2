package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PROB1436 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static List<Integer> films = new ArrayList<>();

    static final String FILM_VERSION = "666";
    static final int MAX = 10000;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    public static void init() {
        int index = 0;
        int current = 666;

        while(index <= MAX) {
            String currentVersion = String.valueOf(current);

            if (currentVersion.contains(FILM_VERSION)) {
                films.add(current);
                index++;
            }

            current++;
        }
    }

    public static void solve() throws IOException {
        N = Integer.parseInt(br.readLine());

        System.out.println(films.get(N - 1));
    }
}
