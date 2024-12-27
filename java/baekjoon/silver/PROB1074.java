package silver;

import java.util.*;
import java.io.*;

public class PROB1074 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, r, c;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(divide(0, 0, (int) Math.pow(2, N)));
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
    }

    public static int divide(int startY, int startX, int size) {
        if (size == 1) {
            return count;
        }

        int newSize = size / 2;
        int area = newSize * newSize;

        if (r < startY + newSize && c < startX + newSize) {
            return divide(startY, startX, newSize);

        } else if (r < startY + newSize && c >= startX + newSize) {
            count += area;
            return divide(startY, startX + newSize, newSize);

        } else if (r >= startY + newSize && c < startX + newSize) {
            count += 2 * area;
            return divide(startY + newSize, startX, newSize);

        } else {
            count += 3 * area;
            return divide(startY + newSize, startX + newSize, newSize);
        }
    }
}