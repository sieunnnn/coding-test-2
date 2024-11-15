package silver;

import java.util.*;
import java.io.*;

public class PROB1654 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int K, N;
    static int[] lengths;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        init();
        long answer = binarySearch();

        System.out.println(answer);
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lengths = new int[K];

        for (int i = 0; i < K; i++) {
            lengths[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lengths[i]);
        }
    }

    public static long binarySearch() {
        long start = 1;
        long end = max;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long count = getCounts(mid);

            if (count >= N) {
                result = mid;
                start = mid + 1;

            } else {
                end = mid - 1;
            }
        }

        return result;
    }

    public static long getCounts(long mid) {
        long count = 0;

        for (int length : lengths) {
            count += length / mid;
        }

        return count;
    }
}
