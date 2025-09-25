package talant_work;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MergeSortJUnitTest {

    @Test
    void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseArray() {
        int[] arr = {5, 4, 3, 2, 1};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testRandomArray() {
        int[] arr = {7, 2, 9, 1};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 7, 9}, arr);
    }
}
