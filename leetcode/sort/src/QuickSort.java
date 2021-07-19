public class QuickSort {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[] { 4, 2, 3, 1 };
        quickSort(arr, 0, 3);
        for (int i = 0; i < 4; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int l = low + 1;
        int h = high;
        while (l <= h) {
            if (arr[l] <= arr[low]) {
                l++;
            } else if (arr[h] >= arr[low]) {
                h--;
            } else {
                int temp = arr[l];
                arr[l] = arr[h];
                arr[h] = temp;
                l++;
                h--;
            }
        }
        int global_temp = arr[low];
        arr[low] = arr[h];
        arr[h] = global_temp;
        return h;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (high + 1 - low < 2)
            return;
        int j = partition(arr, low, high);
        quickSort(arr, low, j);
        quickSort(arr, j + 1, high);
    }
}
