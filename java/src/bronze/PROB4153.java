package bronze;

import java.util.*;
import java.io.*;

public class PROB4153 {
    static BufferedReader br;
    static StringTokenizer st;

    static final int LAST_INDEX = 3;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            init();

            if (numbers[0] == 0 && numbers[1] == 0 && numbers[2] == 0)
                break;
            else {
                String result = isRightTriangle(numbers);
                System.out.println(result);
            }
        }
    }

    public static void init() throws IOException {
        String line = br.readLine();
        st = new StringTokenizer(line);
        numbers = new int[LAST_INDEX];

        for (int i = 0; i < LAST_INDEX; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
    }

    public static String isRightTriangle(int[] numbers) {
        int a = numbers[0];
        int b = numbers[1];
        int c = numbers[2];

        double sum = Math.pow(a, 2) + Math.pow(b, 2);
        double pow = Math.pow(c, 2);

        if (pow == sum )
            return "right";
        else
            return "wrong";
    }
}
