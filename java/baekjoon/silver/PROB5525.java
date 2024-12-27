package silver;

import java.io.*;

public class PROB5525 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int count = 0;
        int i = 0;

        while (i < M - 1) {
            if (S.charAt(i) == 'I' && i + 2 < M && S.charAt(i + 1) == 'O' && S.charAt(i + 2) == 'I') {
                int consecutive = 0;

                while (i + 2 < M && S.charAt(i) == 'I' && S.charAt(i + 1) == 'O' && S.charAt(i + 2) == 'I') {
                    consecutive++;
                    i += 2;
                }

                if (consecutive >= N)
                    count += (consecutive - N + 1);

            } else
                i++;
        }

        System.out.println(count);
    }
}
