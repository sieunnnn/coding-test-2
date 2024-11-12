package silver;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class PROB11650 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static List<Coordinate> coordinates;

    static class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        sort();
        print();
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        coordinates = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            coordinates.add(new Coordinate(x, y));
        }
    }

    public static void sort() {
        coordinates = coordinates
                .stream()
                .sorted((o1, o2) -> {
                    if (o1.x == o2.x)
                        return o1.y - o2.y;

                    return o1.x - o2.x;
                })
                .collect(Collectors.toList());
    }

    public static void print() {
        for (Coordinate coordinate : coordinates) {
            sb.append(coordinate.x).append(" ").append(coordinate.y).append("\n");
        }

        System.out.println(sb);
    }
}
