package silver;

import java.util.*;
import java.io.*;

public class PROB9012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static Stack<String> brackets;

    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void solve() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] strings = br.readLine().split("");
            boolean isBalanced = isBalanced(strings);

            if (isBalanced)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    public static boolean isBalanced(String[] strings) {
        brackets = new Stack<>();

        for (String string : strings) {
            if (string.equals("(") || string.equals("["))
                brackets.push(string);

            else {
                if (string.equals(")")) {
                    if (brackets.isEmpty())
                        return false;

                    else {
                        if (brackets.peek().equals("("))
                            brackets.pop();

                        else if (brackets.peek().equals("["))
                            return false;
                    }

                } else if (string.equals("]")) {
                    if (brackets.isEmpty())
                        return false;

                    else {
                        if (brackets.peek().equals("["))
                            brackets.pop();

                        else if (brackets.peek().equals("("))
                            return false;
                    }
                }
            }
        }

        return brackets.isEmpty();
    }
}
