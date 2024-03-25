/**
 * Provides sorting and searching algorithm implementations.
 * @author Eddie Kwak
 * @version 13.31
 */

public class SortAndSearch {
    /**
     * Returns index where element exists in array.
     * @param <T> Type of Objects in array
     * @param arr Array of Objects to search
     * @param toFind Element to search for
     * @return Index where element is found, or -1 if element is not found
     */
    public static <T extends Comparable<T>> int linearSearch(T[] arr, T toFind) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(toFind) == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Searches an array sorted in ascending order and returns index where element exists in array.
     * @param <T> Type of Objects in array
     * @param arr Array to search, sorted in ascending order
     * @param toFind Element to search for
     * @return Index where element is found, or -1 if element is not found
     */
    public static <T extends Comparable<T>> int binarySearch(T[] arr, T toFind) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int middle = (min + max) / 2;
            if (arr[middle].compareTo(toFind) == 0) {
                return middle;
            } else {
                if (arr[middle].compareTo(toFind) < 0) {
                    min = middle;
                } else {
                    max = middle;
                }
            }
        }
        return -1;
    }

    /**
     * Sorts array in ascending order.
     * @param <T> Type of Objects to sort
     * @param arr The array of Objects to sort
     */
    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min].compareTo(arr[j]) > 0) {
                    min = j;
                }
            }
            if (min != i) {
                T temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    /**
     * Sorts array in ascending order.
     * @param <T> Type of Objects to sort
     * @param arr The array of Objects to sort
     */
    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (arr[j].compareTo(arr[j - 1]) < 0) {
                T temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    /**
     * Sorts array in ascending order.
     * @param <T> Type of Objects to sort
     * @param arr The array of Objects to sort
     */
    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int low = 0;
        int high = arr.length - 1;
        mergeSortRecursion(arr, low, high);
    }

    /**
     * Performs recursion for merge sort.
     * @param <T> Type of element.
     * @param arr Array.
     * @param low Low index.
     * @param high End index.
     */
    private static <T extends Comparable<T>> void mergeSortRecursion(T[] arr, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSortRecursion(arr, low, middle);
            mergeSortRecursion(arr, middle + 1, high);
            merge(arr, low, middle, high);
        }
    }

    /**
     * Helper function for merging.
     * @param <T> Type of element.
     * @param arr Array.
     * @param low Low index.
     * @param middle Middle index.
     * @param high End index.
     */
    private static <T extends Comparable<T>> void merge(T[] arr, int low, int middle, int high) {
        int leftLength = middle - low + 1;
        int rightLength = high - middle;

        T[] left = (T[]) new Comparable[leftLength];
        T[] right = (T[]) new Comparable[rightLength];

        for (int i = 0; i < leftLength; i++) {
            left[i] = arr[low + i];
        }
        for (int j = 0; j < rightLength; j++) {
            right[j] = arr[middle + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = low;
        while (i < leftLength && j < rightLength) {
            if (left[i].compareTo(right[j]) <= 0) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < leftLength) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < rightLength) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}