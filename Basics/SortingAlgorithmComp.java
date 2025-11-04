import java.util.Arrays;
import java.util.Scanner;

/**
 * SortingAlgorithmComp.java
 *
 * This program demonstrates and compares various sorting algorithms:
 *  - Bubble Sort
 *  - Selection Sort
 *  - Insertion Sort
 *  - Merge Sort
 *  - Quick Sort
 *
 * Users can:
 *  - Input an array manually.
 *  - Choose one algorithm to sort.
 *  - OR run a performance comparison across all algorithms.
 *
 * Each algorithm includes:
 *  - Inline explanations of logic.
 *  - JavaDoc-style documentation.
 *  - Time complexity analysis.
 *
 * Author: Your Name
 * Date: 2025-11-03
 */
public class SortingAlgorithmComp {

    // ------------------------------------------------------------------
    // INDIVIDUAL SORTING ALGORITHMS
    // ------------------------------------------------------------------

    /**
     * Bubble Sort Algorithm
     * ---------------------
     * Repeatedly swaps adjacent elements if they are in the wrong order.
     *
     * Time Complexity:
     *   - Best Case: O(n)
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
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Optimization: if no swaps occurred, the array is already sorted
            if (!swapped) break;
        }
    }

    /**
     * Selection Sort Algorithm
     * ------------------------
     * Finds the smallest element in the unsorted portion and places it at the beginning.
     *
     * Time Complexity:
     *   - Best, Average, and Worst Case: O(n^2)
     *
     * @param arr The array to be sorted
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // Find the smallest element in remaining unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            // Swap with first unsorted element
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * Insertion Sort Algorithm
     * ------------------------
     * Builds the final sorted array one element at a time by inserting
     * elements into their correct position.
     *
     * Time Complexity:
     *   - Best Case: O(n)
     *   - Average/Worst Case: O(n^2)
     *
     * @param arr The array to be sorted
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements greater than key one position ahead
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
     * sorts them recursively, and merges the sorted halves.
     *
     * Time Complexity:
     *   - Best/Average/Worst Case: O(n log n)
     *
     * @param arr The array to be sorted
     */
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    // Helper method for merge sort
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    /**
     * Quick Sort Algorithm
     * --------------------
     * Uses a pivot to partition the array and sorts each partition recursively.
     *
     * Time Complexity:
     *   - Best/Average Case: O(n log n)
     *   - Worst Case: O(n^2)
     *
     * @param arr The array to be sorted
     * @param low Starting index
     * @param high Ending index
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Helper method for quick sort partition
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
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

    // ------------------------------------------------------------------
    // PERFORMANCE COMPARISON MODE
    // ------------------------------------------------------------------

    /**
     * comparePerformance
     * ------------------
     * Runs all sorting algorithms on the same dataset and measures their execution time.
     * Displays a formatted comparison table of results.
     *
     * @param originalArr The input array provided by the user
     */
    public static void comparePerformance(int[] originalArr) {
        System.out.println("\n=== Sorting Algorithm Performance Comparison ===");
        System.out.printf("%-20s %-20s\n", "Algorithm", "Execution Time (ns)");
        System.out.println("------------------------------------------------");

        // Create copies of the original array for fairness
        runAndMeasure("Bubble Sort", originalArr, (arr) -> bubbleSort(arr));
        runAndMeasure("Selection Sort", originalArr, (arr) -> selectionSort(arr));
        runAndMeasure("Insertion Sort", originalArr, (arr) -> insertionSort(arr));
        runAndMeasure("Merge Sort", originalArr, (arr) -> mergeSort(arr));
        runAndMeasure("Quick Sort", originalArr, (arr) -> quickSort(arr, 0, arr.length - 1));
    }

    /**
     * Functional interface for passing sorting methods as lambda expressions.
     */
    @FunctionalInterface
    interface SortFunction {
        void sort(int[] arr);
    }

    /**
     * Utility method to clone the input array, run the sorting algorithm,
     * measure execution time, and print the result.
     *
     * @param name The name of the sorting algorithm
     * @param original The original unsorted array
     * @param sorter The sorting method to execute
     */
    private static void runAndMeasure(String name, int[] original, SortFunction sorter) {
        int[] arrCopy = Arrays.copyOf(original, original.length);
        long start = System.nanoTime();
        sorter.sort(arrCopy);
        long end = System.nanoTime();
        System.out.printf("%-20s %-20d\n", name, (end - start));
    }

    // ------------------------------------------------------------------
    // MAIN PROGRAM ENTRY POINT
    // ------------------------------------------------------------------

    /**
     * Main method
     * ------------
     * Handles user interaction and calls sorting or comparison functions.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println("\nChoose an option:");
        System.out.println("1. Sort using one algorithm");
        System.out.println("2. Compare performance of all algorithms");
        int mode = sc.nextInt();

        if (mode == 1) {
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
        else if (mode == 2) {
            comparePerformance(arr);
        } 
        else {
            System.out.println("Invalid option.");
        }
    }
}
