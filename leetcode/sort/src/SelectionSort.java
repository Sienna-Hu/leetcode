public class SelectionSort {

  public static void main(String[] args) {
    int[] arr = new int[] { 4, 2, 3, 1 };
    selectionSort(arr);
    for (int i = 0; i < 4; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void selectionSort(int[] arr) {
    int k = 0;
    while (k < arr.length) {
      int min_index = k;
      for (int i = k; i < arr.length; i++) {
        if (arr[i] < arr[min_index]) {
          min_index = i;
        }
      }
      int temp = arr[min_index];
      arr[min_index] = arr[k];
      arr[k] = temp;
      k++;
    }
  }
}
