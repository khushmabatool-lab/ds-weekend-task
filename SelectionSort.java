import java.util.Random;

public class SelectionSort {

    public static void main(String[] args) {

        int size = 50000;
        int[] arr = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100000);
        }

        long startTime = System.nanoTime();

        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        long endTime = System.nanoTime();
        long elapsed = endTime - startTime;

        System.out.println("===== Selection Sort Completed =====");
        System.out.println("Total Elements: " + size);
        System.out.println("Execution Time in Nanoseconds: " + elapsed);
        System.out.println("Execution Time in Milliseconds: "
                + elapsed / 1_000_000.0);

        System.out.println("First 20 Sorted Elements:");
        for (int i = 0; i < Math.min(20, size); i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}