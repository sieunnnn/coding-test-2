package silver;

import java.util.*;
import java.io.*;

public class PROB10773 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static List<Integer> numbers = new ArrayList<>();

    static final int REMOVER = 0;

    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void solve() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            int lastId = numbers.size() - 1;

            if (input == REMOVER)
                numbers.remove(lastId);
            else
                numbers.add(input);
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        System.out.println(sum);
    }
}
