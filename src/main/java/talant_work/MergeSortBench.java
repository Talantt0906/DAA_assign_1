package talant_work;

import java.util.Random;
import java.io.IOException;

public class MergeSortBench {
    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000, 5000, 10000}; 
        Random rand = new Random();

        try {
            CSVWriter csv = new CSVWriter("results.csv");
            csv.writeRow("n", "time(ms)", "comparisons", "maxDepth");

            for (int n : sizes) {
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = rand.nextInt(100000);
                }

                Metrics.reset();

                long start = System.currentTimeMillis();
                MergeSort.sort(arr);
                long end = System.currentTimeMillis();

                csv.writeRow(
                    String.valueOf(n),
                    String.valueOf(end - start),
                    String.valueOf(Metrics.comparisons),
                    String.valueOf(Metrics.maxDepth)
                );
            }

            csv.close();
            System.out.println("Benchmark finished. Results written to results.csv");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
