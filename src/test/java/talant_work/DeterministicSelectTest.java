package talant_work;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class DeterministicSelectTest {

    @Test
    public void testSmallArrays() {
        int[] arr1 = {5, 3, 1, 4, 2};
        assertEquals(3, DeterministicSelect.select(arr1, 2)); 

        int[] arr2 = {10, 20, 30, 40, 50};
        assertEquals(40, DeterministicSelect.select(arr2, 3)); 
    }

    @Test
    public void testRandomArrays() {
        Random rand = new Random();
        for (int t = 0; t < 10; t++) { 
            int n = 100 + rand.nextInt(900); 
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = rand.nextInt(10000);

            int k = n / 2; 
            int expected = Arrays.copyOf(arr, n)[k];
            Arrays.sort(arr);
            expected = arr[k]; 

            int[] arrCopy = Arrays.copyOf(arr, n);
            int result = DeterministicSelect.select(arrCopy, k);
            assertEquals(expected, result, "Failed on array size: " + n);
        }
    }
}

