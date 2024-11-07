package bronze;

import java.io.*;

public class PROB2292 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int begin, end = 1;
        int rooms = 0;

        while(true) {
            begin = end + 1;
            end = begin + (6 * rooms) - 1;
            rooms ++;

            if (N <= end) {
                break;
            }
        }
        System.out.println(rooms);
    }
}
