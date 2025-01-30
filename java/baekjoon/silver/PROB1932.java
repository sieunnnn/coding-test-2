package silver;

import java.io.*;
import java.util.*;

public class PROB1932 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static ArrayList<int[]> triangleNumbers = new ArrayList<>();
    static ArrayList<int[]> dp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        solve();
        findMax();
    }

    public static void init() throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int counts = st.countTokens();
            int [] temp = new int[counts];

            dp.add(temp);

            for (int j = 0; j < counts; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }

            triangleNumbers.add(temp);
        }
    }

    public  static void solve() {
        for (int i = 1; i < n; i ++) {
            int startIdx = 0;
            int lastIdx = triangleNumbers.get(i).length - 1;

            for (int j = 0; j <= lastIdx; j++) {
                int upLeft = j != startIdx ? triangleNumbers.get(i-1)[j - 1] : -1;
                int up = j != lastIdx ? triangleNumbers.get(i-1)[j] : -1;
                int current = triangleNumbers.get(i)[j];

                if (j == startIdx)
                    dp.get(i)[j] = up + current;

                else if (j == lastIdx)
                    dp.get(i)[j] = upLeft + current;

                dp.get(i)[j] = Math.max(upLeft + current, up + current);
            }
        }
    }

    public static void findMax() {
        int max = 0;

        for (int values : dp.get(n - 1))
            max = Math.max(values, max);

        System.out.println(max);
    }
}
