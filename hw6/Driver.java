/**
 * Driver program.
 * @author Eddie Kwak
 * @version 13.31
 */
public class Driver {
    /**
     * Main function of driver.
     * @param args Arguments.
     */
    public static void main(String[] args) {
        System.out.println("(1) Sorting the natoAlphabetUnsorted Array Using Insertion Sort: ");
        //System.out.println("Original Array: ");
        ArrayGenerator original1 = new ArrayGenerator();
        //original1.arrayPrinter(original1.natoAlphabetUnsorted);
        AlgorithmBenchmark solution1 = new AlgorithmBenchmark();
        solution1.sortAndBenchmark(original1.natoAlphabetUnsorted, SortAlgorithm.INSERTION);
        original1.arrayPrinter(original1.natoAlphabetUnsorted);
        System.out.println();

        System.out.println("(2) Sorting Random Array of 1331 Integers Using Merge Sort: ");
        Integer[] original2 = ArrayGenerator.generateRandomIntArray(1331);
        //original1.arrayPrinter(original2);
        AlgorithmBenchmark solution2 = new AlgorithmBenchmark();
        solution2.sortAndBenchmark(original2, SortAlgorithm.MERGE);
        //original1.arrayPrinter(original2);
        System.out.println();

        System.out.println("(3) Sorting an Integer Array Read in from pi.txt File Using Selection Sort: ");
        Integer[] original3 = ArrayGenerator.integerArrayFromFile("pi.txt");
        //original1.arrayPrinter(original3);
        //System.out.println("_____________________________________");
        AlgorithmBenchmark solution3 = new AlgorithmBenchmark();
        solution3.sortAndBenchmark(original3, SortAlgorithm.SELECTION);
        //original1.arrayPrinter(original3);
        //System.out.println(original3.length);
        System.out.println();

        System.out.println("(4) Searching for 'Hotel' in natoAlphabetUnsorted using Binary search: ");
        ArrayGenerator original4 = new ArrayGenerator();
        AlgorithmBenchmark solution4 = new AlgorithmBenchmark();
        solution4.searchAndBenchmark(original4.natoAlphabetUnsorted, "Hotel", SearchAlgorithm.LINEAR);
        System.out.println();

        System.out.print("(5) Searching for 'Juliett' in sorted version of ");
        System.out.println("natoAlphabetUnsorted using Linear search: ");
        solution4.searchAndBenchmark(original4.natoAlphabetUnsorted, "Juliett", SearchAlgorithm.BINARY);
    }
}