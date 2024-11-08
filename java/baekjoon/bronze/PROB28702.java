package bronze;

import java.io.*;

public class PROB28702 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static final int INPUT_SIZE = 3;

    static int order;

    public static void main(String[] args) throws IOException {
        init();
        String answer = solve();

        System.out.println(answer);
    }

    public static void init() throws IOException {
        for (int i = 0; i < INPUT_SIZE; i++) {
            String input = br.readLine();

            if (isNumber(input)) {
                order = Integer.parseInt(input) + (INPUT_SIZE - i);
                break;
            }
        }
    }

    public static String solve() {
        if (order % 15 == 0)
            return "FizzBuzz";

        else if (order % 3 == 0)
            return "Fizz";

        else if (order % 5 == 0)
            return "Buzz";

        else
            return String.valueOf(order);
    }

    public static boolean isNumber(String str) {
        return str.matches("[+-]?\\d*(\\.\\d+)?");
    }
}
