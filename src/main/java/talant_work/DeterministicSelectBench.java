package talant_work;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DeterministicSelectBench {

    public static void main(String[] args) {
        
        int[] sizes = {10, 100, 1000, 5000, 10000};
        
        String fileName = "D:/DAA_Assignment1/DAA_assign/deterministic_select_results.csv";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("n,time(ms),result\n"); 

            for (int n : sizes) {
                int[] arr = generateRandomArray(n);
                int k = n / 2; 

                System.out.println("Running select for n=" + n);

                long start = System.nanoTime();
                int result = DeterministicSelect.select(arr, k);
                long end = System.nanoTime();

                long timeMs = (end - start) / 1_000_000; 

                
                System.out.println("n=" + n + ", result=" + result + ", time=" + timeMs + "ms");

                
                writer.write(n + "," + timeMs + "," + result + "\n");
            }

            System.out.println("CSV file written: " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    private static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = rand.nextInt(100_000);
        return arr;
    }
}