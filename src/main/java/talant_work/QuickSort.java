package talant_work;

import java.util.Random;

public class QuickSort {

    private static long comparisons = 0;
    private static int maxDepth = 0;

    public static void resetMetrics() {
        comparisons = 0;
        maxDepth = 0;
    }

    public static long getComparisons() {
        return comparisons;
    }

    public static int getMaxDepth() {
        return maxDepth;
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1, 0);
    }

    private static void quickSort(int[] arr, int left, int right, int depth) {
        if (left >= right) return;

        maxDepth = Math.max(maxDepth, depth);

        
        int pivotIndex = randomizedPartition(arr, left, right);
        int leftSize = pivotIndex - left;
        int rightSize = right - pivotIndex;

        if (leftSize < rightSize) {
            quickSort(arr, left, pivotIndex - 1, depth + 1);
            left = pivotIndex + 1; 
        } else {
            quickSort(arr, pivotIndex + 1, right, depth + 1);
            right = pivotIndex - 1; 
        }

        
        while (left < right) {
            pivotIndex = randomizedPartition(arr, left, right);
            leftSize = pivotIndex - left;
            rightSize = right - pivotIndex;

            if (leftSize < rightSize) {
                quickSort(arr, left, pivotIndex - 1, depth + 1);
                left = pivotIndex + 1;
            } else {
                quickSort(arr, pivotIndex + 1, right, depth + 1);
                right = pivotIndex - 1;
            }
        }
    }

    private static int randomizedPartition(int[] arr, int left, int right) {
        Random rand = new Random();
        int pivotIndex = left + rand.nextInt(right - left + 1);
        swap(arr, pivotIndex, right);
        return partition(arr, left, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            comparisons++;
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
