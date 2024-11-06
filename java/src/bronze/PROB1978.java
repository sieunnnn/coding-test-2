package bronze;

import java.io.*;
import java.util.*;

public class PROB1978 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[] numbers;
    static boolean[] isPrimeNumber = new boolean[1001];

    public static void main(String[] args) throws IOException {
        init();
        findPrimeNumber();

        int answer = 0;
        for (int i = 0; i < numbers.length; i++) {
            boolean result = isPrimeNumber[numbers[i]];
            if (result)
                answer++;
        }

        System.out.println(answer);
    }

    public static void init()throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String line = br.readLine();
        st = new StringTokenizer(line);

        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void findPrimeNumber() {
        Arrays.fill(isPrimeNumber, true);

        isPrimeNumber[0] = false;
        isPrimeNumber[1] = false;
        for (int i = 2; i <= Math.sqrt(1000); i++) {
            if (isPrimeNumber[i]) {
                for (int j = i * i; j < 1001; j += i)
                    isPrimeNumber[j] = false;
            }
        }
    }
}
