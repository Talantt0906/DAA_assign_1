package main.java.talant_work;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ClosestPairBench {

    public static void main(String[] args) throws IOException {
        int[] ns = {10, 100, 1000, 5000, 10000};
        Random rand = new Random();

        try (FileWriter writer = new FileWriter("closest_pair_result.csv")) {
            writer.write("n,time(ms)\n");

            for (int n : ns) {
                ClosestPair.Point[] points = new ClosestPair.Point[n];
                for (int i = 0; i < n; i++) {
                    points[i] = new ClosestPair.Point(rand.nextDouble() * 1000, rand.nextDouble() * 1000);
                }

                long start = System.nanoTime();
                ClosestPair.Result result = ClosestPair.closestPair(points);
                long end = System.nanoTime();
                long timeMs = (end - start) / 1_000_000;

                writer.write(n + "," + timeMs + "\n");
                System.out.println("n=" + n + ", time=" + timeMs + " ms, closest distance=" + result.dist);
            }
        }
    }
}
