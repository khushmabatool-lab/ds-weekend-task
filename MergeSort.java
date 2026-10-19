import java.util.Random;

public class MergeSort {

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

        mergeSort(arr, 0, n - 1);

        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        // Display results
        System.out.println("===== Merge Sort Completed =====");
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

    public static void mergeSort(int[] arr, int left, int right) {

        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
