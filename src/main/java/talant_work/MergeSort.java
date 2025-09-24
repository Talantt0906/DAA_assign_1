package talant_work;

public class MergeSort {

    private static final int SMALL = 16;

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        Metrics.reset();
        int[] temp = new int[arr.length]; 
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        Metrics.enterRecursion();

        if (right - left <= SMALL) { 
            insertSort(arr, left, right);
            Metrics.exitRecursion();
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);

        merge(arr, left, mid, right, temp);

        Metrics.exitRecursion();
    }

    private static void insertSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                Metrics.comparisons++;
                arr[j + 1] = arr[j];
                j--;
            }
            if (j >= left) Metrics.comparisons++;
            arr[j + 1] = key;
        }
    }

    
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;      
        int j = mid + 1;   
        int k = left;      

        while (i <= mid && j <= right) {
            Metrics.comparisons++;
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        while (i <= mid) arr[k++] = temp[i++];
        while (j <= right) arr[k++] = temp[j++];
    }
}
