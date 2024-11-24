package silver;

import java.util.*;
import java.io.*;

public class PROB5430 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static final String FIRST = "FIRST";
    static final String LAST = "LAST";
    static final String ERROR = "error";

    static int T;
    static Deque<Integer> numbers;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(sb);
    }

    public static void init() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String array = br.readLine();

            initDeque(array);
            solve(p);
        }
    }

    public static void initDeque(String array) {
        numbers = new ArrayDeque<>();
        array = array.substring(1, array.length() - 1);
//        System.out.println(array);

        if (!array.isEmpty()) {
            String[] temp = array.split(",");
            for (String number : temp) {
                numbers.addLast(Integer.parseInt(number));
            }
        }
    }

    public static void solve(String p) {
        String currentPointer = FIRST;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == 'R') {
                if (currentPointer.equals(FIRST))
                    currentPointer = LAST;
                else
                    currentPointer = FIRST;

            } else if (p.charAt(i) == 'D') {
                if (numbers.isEmpty()) {
                    sb.append(ERROR).append("\n");
                    return;
                }

                if (currentPointer.equals(LAST))
                    numbers.removeLast();
                else
                    numbers.removeFirst();
            }
        }

        print(currentPointer);
    }

    public static void print(String currentPointer) {
        sb.append("[");

        if (!numbers.isEmpty()) {
            if (currentPointer.equals(LAST)) {
                while (!numbers.isEmpty()) {
                    sb.append(numbers.pollLast());

                    if (!numbers.isEmpty())
                        sb.append(",");
                }
            } else {
                while (!numbers.isEmpty()) {
                    sb.append(numbers.pollFirst());

                    if (!numbers.isEmpty())
                        sb.append(",");
                }
            }
        }

        sb.append("]").append("\n");
    }
}
