package softeer.level2;

import java.io.*;
import java.util.*;

public class PROB02 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static List<String> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++)
            numbers.add(br.readLine());

        numbers.sort((o1, o2) -> {
            String[] partsA = o1.split("\\.");
            String[] partsB = o2.split("\\.");

            int len = Math.min(partsA.length, partsB.length);
            for (int i = 0; i < len; i++) {
                int numA = Integer.parseInt(partsA[i]);
                int numB = Integer.parseInt(partsB[i]);
                if (numA != numB) {
                    return Integer.compare(numA, numB);
                }
            }
            return Integer.compare(partsA.length, partsB.length);
        });

        for (String num : numbers)
            sb.append(num).append("\n");

        System.out.print(sb);
    }
}
