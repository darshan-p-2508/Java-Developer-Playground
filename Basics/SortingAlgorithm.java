import java.util.Arrays;
import java.util.Scanner;

/**
 * SortingAlgorithm.java
 *
 * This program demonstrates various sorting algorithms:
 * Bubble Sort, Selection Sort, Insertion Sort, Merge Sort, and Quick Sort.
 * 
 * It allows the user to:
 *  - Input an array manually.
 *  - Choose a sorting algorithm.
 *  - View the sorted array and execution time.
 *
 * Each sorting algorithm includes:
 *  - Inline explanations of logic.
 *  - Time complexity analysis.
 *
 * Author: Darshan P
 * Date: 2025-11-03
 */
public class SortingAlgorithm {

    /**
     * Bubble Sort Algorithm
     * ---------------------
     * Repeatedly swaps adjacent elements if they are in the wrong order.
     * 
     * Time Complexity:
     *   - Best Case: O(n) [already sorted]
     *   - Average Case: O(n^2)
     *   - Worst Case: O(n^2)
     * 
     * @param arr The array to be sorted
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Optimization: stop if no swaps occurred in the inner loop
            if (!swapped) break;
        }
    }

    /**
     * Selection Sort Algorithm
     * ------------------------
     * Repeatedly finds the minimum element and moves it to the sorted portion.
     * 
     * Time Complexity:
     *   - Best Case: O(n^2)
     *   - Average Case: O(n^2)
     *   - Worst Case: O(n^2)
     * 
     * @param arr The array to be sorted
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // Find the smallest element in the remaining unsorted array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum with the first unsorted element
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * Insertion Sort Algorithm
     * ------------------------
     * Builds the final sorted array one item at a time.
     * 
     * Time Complexity:
     *   - Best Case: O(n) [already sorted]
     *   - Average Case: O(n^2)
     *   - Worst Case: O(n^2)
     * 
     * @param arr The array to be sorted
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements greater than key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * Merge Sort Algorithm
     * --------------------
     * A divide-and-conquer algorithm that divides the array into halves,
     * recursively sorts them, and merges the results.
     * 
     * Time Complexity:
     *   - Best Case: O(n log n)
     *   - Average Case: O(n log n)
     *   - Worst Case: O(n log n)
     * 
     * @param arr The array to be sorted
     */
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        // Recursively sort both halves
        mergeSort(left);
        mergeSort(right);

        // Merge sorted halves
        merge(arr, left, right);
    }

    // Helper method for merge sort
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    /**
     * Quick Sort Algorithm
     * --------------------
     * A divide-and-conquer algorithm that selects a pivot, partitions
     * the array, and recursively sorts the partitions.
     * 
     * Time Complexity:
     *   - Best Case: O(n log n)
     *   - Average Case: O(n log n)
     *   - Worst Case: O(n^2) [rare, occurs when pivot is poorly chosen]
     * 
     * @param arr The array to be sorted
     * @param low Starting index
     * @param high Ending index
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            // Recursively sort left and right partitions
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Helper method for quick sort partitioning
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose the last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * Main method
     * ------------
     * Handles user input and executes the selected sorting algorithm.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println("\nChoose Sorting Algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Merge Sort");
        System.out.println("5. Quick Sort");
        int choice = sc.nextInt();

        System.out.println("\nBefore Sorting: " + Arrays.toString(arr));
        long start = System.nanoTime();

        switch (choice) {
            case 1 -> bubbleSort(arr);
            case 2 -> selectionSort(arr);
            case 3 -> insertionSort(arr);
            case 4 -> mergeSort(arr);
            case 5 -> quickSort(arr, 0, arr.length - 1);
            default -> {
                System.out.println("Invalid choice.");
                return;
            }
        }

        long end = System.nanoTime();
        System.out.println("After Sorting: " + Arrays.toString(arr));
        System.out.println("Execution Time: " + (end - start) + " ns");
    }
}
