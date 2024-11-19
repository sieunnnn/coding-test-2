package silver;

import java.io.*;
import java.util.*;

public class PROB2805 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        init();
        long answer = binarySearch();

        System.out.println(answer);
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            trees[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(trees);
    }

    public static int binarySearch() {
        int start = 0;
        int end = trees[trees.length - 1];
        int answer = 0;

        while(start <= end) {
            int mid = (start + end) / 2;
            long sum = getSums(mid);

            if (sum >= M) {
                answer = mid;
                start = mid + 1;

            } else
                end = mid - 1;
        }
        return answer;
    }

    public static long getSums(int mid) {
        long count = 0;

        for (int tree : trees) {
            if (tree > mid)
                count += (tree - mid);
        }

        return count;
    }
}
