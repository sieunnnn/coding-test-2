package silver;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class PROB18110 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static List<Integer> difficulties = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        sortAndRemoveUnnecessaryDifficulties();
        calculateDifficulty();
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            difficulties.add(Integer.parseInt(br.readLine()));
        }
    }

    public static void sortAndRemoveUnnecessaryDifficulties() {
        difficulties = difficulties
                .stream()
                .sorted()
                .collect(Collectors.toList());

        int removeValue = (int) Math.round(N * 0.15);

        difficulties = difficulties
                .subList(removeValue, difficulties.size() - removeValue);
    }

    public static void calculateDifficulty() {
        int sum = 0;

        for (int difficulty : difficulties) {
            sum += difficulty;
        }

        int avg = (int) Math.round((double) sum / difficulties.size());

        System.out.println(avg);
    }
}
