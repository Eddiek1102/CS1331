/**
 * Utility methods to measure the runtime of sorting algorithms.
 * @author David Gallagher
 * @version 13.31
 */
public class AlgorithmBenchmark {
    /**
     * Sets the unit used by the benchmark.
     */
    private static final TimeUnit BENCHMARK_UNIT = TimeUnit.MILLISECONDS;
    
    /**
     * Time measurement options for the benchmark.
     */
    private enum TimeUnit {
        NANOSECONDS("nanos"), MILLISECONDS("ms"), SECONDS("s");

        private String unitStr;

        private TimeUnit(String unitStr) {
            this.unitStr = unitStr;
        }

        public String toString() {
            return unitStr;
        }
    }

    /**
     * Sorts array in ascending order and prints information about sort's time to complete.
     * @param <T> Type of Objects to sort
     * @param arr The array of Objects to sort
     * @param algorithm The sorting algorithm to benchmark
     */
    public static <T extends Comparable<T>> void sortAndBenchmark(T[] arr, SortAlgorithm algorithm) {
        long before, after;

        before = (BENCHMARK_UNIT == TimeUnit.NANOSECONDS) ? System.nanoTime() : System.currentTimeMillis();
        
        switch (algorithm) {
        case SELECTION:
            SortAndSearch.selectionSort(arr);
            break;
        case INSERTION:
            SortAndSearch.insertionSort(arr);
            break;
        case MERGE:
            SortAndSearch.mergeSort(arr);
            break;
        }

        after = (BENCHMARK_UNIT == TimeUnit.NANOSECONDS) ? System.nanoTime() : System.currentTimeMillis();
        if (BENCHMARK_UNIT == TimeUnit.SECONDS) {
            after /= 1000;
            before /= 1000;
        }

        System.out.printf("%9s took %d %s%n", algorithm, after - before, BENCHMARK_UNIT);
    }

    /**
     * Searches array for specified element and prints information about search's time to complete.
     * @param <T> Type of Objects in array
     * @param arr Array of Objects to search
     * @param toFind Element to find
     * @param algorithm The search algorithm to benchmark
     * @throws IllegalArgumentException SearchAlgorithm must be valid
     */
    public static <T extends Comparable<T>> void searchAndBenchmark(T[] arr, T toFind, SearchAlgorithm algorithm) {
        long before, after;

        int idx = -1331;

        before = (BENCHMARK_UNIT == TimeUnit.NANOSECONDS) ? System.nanoTime() : System.currentTimeMillis();
        
        switch (algorithm) {
        case LINEAR:
            idx = SortAndSearch.linearSearch(arr, toFind);
            break;
        case BINARY:
            idx = SortAndSearch.binarySearch(arr, toFind);
            break;
        default:
            throw new IllegalArgumentException("SearchAlgorithm must not be null");
        }
        
        after = (BENCHMARK_UNIT == TimeUnit.NANOSECONDS) ? System.nanoTime() : System.currentTimeMillis();
        if (BENCHMARK_UNIT == TimeUnit.SECONDS) {
            after /= 1000;
            before /= 1000;
        }

        System.out.printf("%9s took %d %s, found entry at %d%n", algorithm, after - before, BENCHMARK_UNIT, idx);
    }
}