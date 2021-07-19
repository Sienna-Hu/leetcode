public class MergeSort {

  public static void main(String[] args) throws Exception {
    int[] arr = new int[] { 4, 2, 3, 1 };
    mergeSort(arr, 0, 3);
    for (int i = 0; i < 4; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void mergeSort(int[] arr, int start, int end) {
    if (start >= end)
      return;
    int mid = (start + end) / 2;
    mergeSort(arr, start, mid);
    mergeSort(arr, mid + 1, end);
    merge(arr, start, mid, end);

  }

  public static void merge(int[] arr, int start, int mid, int end) {
    if (start >= end)
      return;
    int[] copy = new int[mid + 1 - start];
    for (int i = start; i <= mid; i++) {
      copy[i - start] = arr[i];
    }
    int i = start; // 1st arr
    int j = mid + 1; // 2nd arr
    int m = 0; // copy of 1st arr
    while (j <= end && m < mid + 1 - start) {
      if (copy[m] <= arr[j]) {
        arr[i] = copy[m];
        i++;
        m++;
      } else {
        arr[i] = arr[j];
        i++;
        j++;
      }
    }
    while (m < mid + 1 - start) {
      arr[i] = copy[m];
      i++;
      m++;
    }
  }
}
