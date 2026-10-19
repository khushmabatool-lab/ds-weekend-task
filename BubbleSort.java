import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {

        int size = 50000;
        int[] arr = new int[size];
        Random random = new Random();

        // Generate random numbers
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100000);
        }

        // Start timing
        long startTime = System.nanoTime();

        // Bubble Sort algorithm
        for (int i = 0; i < size - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < size - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        // End timing
        long endTime = System.nanoTime();
        long elapsed = endTime - startTime;

        // Display results
        System.out.println("===== Bubble Sort Completed =====");
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
    
