package silver;

import java.io.*;

public class PROB2751 {
    static  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        init();
        divide(numbers, 0, N - 1);
        print();
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void divide(int[] array, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;

            divide(array, start, mid);
            divide(array, mid + 1, end);

            mergeSort(array, start, mid, end);
        }
    }

    public static void mergeSort(int[] array, int start, int mid, int end) {
        int leftArraySize = mid - start + 1;
        int rightArraySize = end - mid;

        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];

        for (int i = 0; i < leftArraySize; i++) {
            leftArray[i] = array[start + i];
        }

        for (int i = 0; i < rightArraySize; i++) {
            rightArray[i] = array[mid + 1 + i];
        }

        // merge
        int i = 0;
        int j = 0;
        int k = start;

        while (i < leftArraySize && j < rightArraySize) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;

            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // remain numbers
        while(i < leftArraySize) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while(j < rightArraySize) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void print() {
        for (int num : numbers) {
            System.out.println(num);
        }
    }
}
