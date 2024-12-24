package gold;

import java.util.*;
import java.io.*;

public class PROB7662 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T;

    public static void main(String[] args) throws IOException {
        init();
    }

    public static void init() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int Q = Integer.parseInt(br.readLine());

            for (int j = 0; j < Q; j++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int number = Integer.parseInt(st.nextToken());

                if (command.equals("I"))
                    map.put(number, map.getOrDefault(number, 0) + 1);

                else if (command.equals("D")) {
                    if (number == 1 && !map.isEmpty()) {
                        int max = map.lastKey();

                        if (map.get(max) == 1)
                            map.remove(max);
                        else
                            map.put(max, map.getOrDefault(max, 0) - 1);
                    }

                    else if (number == -1 && !map.isEmpty()) {
                        int min = map.firstKey();

                        if (map.get(min) == 1)
                            map.remove(min);
                        else
                            map.put(min, map.getOrDefault(min, 0) - 1);
                    }
                }
            }

            if (map.isEmpty())
                System.out.println("EMPTY");

            else {
                int max = map.lastKey();
                int min = map.firstKey();

                System.out.println(max + " " + min);
            }
        }
    }
}
