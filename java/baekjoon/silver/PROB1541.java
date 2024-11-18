package silver;

import java.util.*;
import java.io.*;

public class PROB1541 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void solve() throws IOException {
        String[] input = br.readLine().split("-");
//        System.out.println(Arrays.toString(input));

        for (String string : input) {
            String[] temp = string.split("\\+");
            int sum = 0;
//            System.out.println(Arrays.toString(temp));

            for (String value : temp)
                sum += Integer.parseInt(value);

            numbers.add(sum);
        }

        int answer = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++)
            answer -= numbers.get(i);

        System.out.println(answer);
    }
}
