import java.util.Random;

public class InsertionSort {

    public static void main(String[] args) {

        int n = 50000;
        int[] arr = new int[n];
        Random random = new Random();

        // Generate random numbers
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100000);
        }

        // Measure execution time
        long startTime = System.nanoTime();

        // Insertion Sort
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        // Display results
        System.out.println("===== Insertion Sort Completed =====");
        System.out.println("Total Elements: " + n);
        System.out.println("Execution Time in Nanoseconds: " + executionTime);
        System.out.println("Execution Time in Milliseconds: "
                + (executionTime / 1000000.0));

        System.out.println("First 20 Sorted Elements:");

        for (int i = 0; i < Math.min(20, n); i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}