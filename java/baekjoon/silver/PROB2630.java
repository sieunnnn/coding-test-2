package silver;

import java.util.*;
import java.io.*;

public class PROB2630 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] paper;
    static int blueCount = 0;
    static int whiteCount = 0;

    public static void main(String[] args) throws IOException {
        init();
        divide(0,0, N);

        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++)
                paper[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    public static void divide(int startY, int startX, int size) {
        if (isSingleColor(startY, startX, size)) {
            if (paper[startY][startX] == 0)
                whiteCount++;
            else
                blueCount++;
            return;
        }

        int newSize = size / 2;

        divide(startY, startX, newSize);
        divide(startY, startX + newSize, newSize);
        divide(startY + newSize, startX, newSize);
        divide(startY + newSize, startX + newSize, newSize);
    }

    public static boolean isSingleColor(int startY, int startX, int size) {
        int color = paper[startY][startX];

        for (int i = startY; i < startY + size; i++) {
            for (int j = startX; j < startX + size; j++) {
                if (paper[i][j] != color)
                    return false;
            }
        }
        return true;
    }
}
