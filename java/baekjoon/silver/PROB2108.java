package silver;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class PROB2108 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] numbers;
    static Map<Integer, Integer> map = new HashMap<>();
    static int maxCount = 0;

    public static void main(String[] args) throws IOException {
        init();
        calculateArithmeticMean();
        findMedian();
        findMode();
        findRange();
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
            maxCount = Math.max(maxCount, map.get(numbers[i]));
        }
    }

    public static void calculateArithmeticMean() {
        int sum = 0;

        for (int number : numbers)
            sum += number;

        int arithmeticMean = (int) Math.round((double) sum / N);

        System.out.println(arithmeticMean);
    }

    public static void findMedian() {
        int mid = (int) Math.ceil((double) N / 2) - 1;
        Arrays.sort(numbers);

        System.out.println(numbers[mid]);
    }

    public static void findMode() {
        List<Integer> modes = new ArrayList<>();

        for (int key : map.keySet()) {
            int value = map.get(key);

            if(value == maxCount)
                modes.add(key);
        }

        if (modes.size() > 1) {
            modes = modes.stream()
                    .sorted()
                    .collect(Collectors.toList());

            System.out.println(modes.get(1));

        } else
            System.out.println(modes.get(0));
    }

    public static void findRange() {
        int max = numbers[numbers.length - 1];
        int min = numbers[0];

        System.out.println(max - min);
    }
}
