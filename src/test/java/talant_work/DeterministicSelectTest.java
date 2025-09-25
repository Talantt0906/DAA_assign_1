package talant_work;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DeterministicSelectTest {

    @Test
    public void testBasicArray() {
        int[] arr = {5, 3, 1, 4, 2};
        assertEquals(3, DeterministicSelect.select(arr, 2)); 
    }

    @Test
    public void testSingleElement() {
        int[] arr = {42};
        assertEquals(42, DeterministicSelect.select(arr, 0));
    }

    @Test
    public void testLargerArray() {
        int[] arr = {10, 2, 5, 3, 7, 1, 9, 8, 4, 6};
        assertEquals(5, DeterministicSelect.select(arr, 4)); 
        assertEquals(1, DeterministicSelect.select(arr, 0)); 
        assertEquals(10, DeterministicSelect.select(arr, 9)); 
    }
}

