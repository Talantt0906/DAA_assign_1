package talant_work;

public class DeterministicSelect {

    public static int select(int[] arr, int k) {
        return select(arr, 0, arr.length - 1, k);
    }

    private static int select(int[] arr, int left, int right, int k) {
        if (left == right) return arr[left];

        int pivotIndex = pivotIndex(arr, left, right);
        pivotIndex = partition(arr, left, right, pivotIndex);

        if (k == pivotIndex) return arr[k];
        else if (k < pivotIndex) return select(arr, left, pivotIndex - 1, k);
        else return select(arr, pivotIndex + 1, right, k);
    }

    private static int pivotIndex(int[] arr, int left, int right) {
        
        if (right - left < 5) {
            insertionSort(arr, left, right);
            return left + (right - left) / 2;
        }

        
        int numMedians = 0;
        for (int i = left; i <= right; i += 5) {
            int subRight = Math.min(i + 4, right);
            insertionSort(arr, i, subRight);
            int median = i + (subRight - i) / 2;
            swap(arr, left + numMedians, median);
            numMedians++;
        }

        
        return select(arr, left, left + numMedians - 1, left + numMedians / 2);
    }

    private static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        swap(arr, right, storeIndex);
        return storeIndex;
    }

    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

