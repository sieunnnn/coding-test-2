package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PROB1259 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String str;
    static String reversedStr;

    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();

        while(true) {
            str = br.readLine();
            if (str.equals("0"))
                break;

            StringBuilder sb = new StringBuilder(str);
            reversedStr = sb.reverse().toString();
//            System.out.println(str);
//            System.out.println(reversedStr);

            if (str.equals(reversedStr))
                answer.append("yes").append("\n");
            else
                answer.append("no").append("\n");
        }

        System.out.println(answer);
    }
}
