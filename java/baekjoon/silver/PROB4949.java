package silver;

import java.util.*;
import java.io.*;

public class PROB4949 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static Stack<String> brackets;

    static final String EOL = ".";
    static final String Y = "yes";
    static final String N = "no";

    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void solve() throws IOException {
        while(true) {
            String line = br.readLine();
            if (line.equals(EOL))
                break;
            else {
                String[] strings = line.split("");
                boolean isBalanced = isBalanced(strings);

                if (isBalanced)
                    System.out.println(Y);
                else
                    System.out.println(N);
            }
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
