package bronze;

import java.io.*;
import java.util.*;

public class PROB11050 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int[][] numbers;

    public static void main(String[] args) throws IOException {
        init();

        System.out.println(numbers[N][K]);
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        numbers = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    numbers[i][j] = 1;
                else
                    numbers[i][j] = numbers[i - 1][j] + numbers[i - 1][j - 1];
            }
        }

//        System.out.println(Arrays.deepToString(numbers));
    }
}
