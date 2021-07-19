public class InsertionSort {

  public static void main(String[] args) throws Exception {
    int[] arr = new int[] { 4, 2, 3, 1 };
    insertionSort(arr);
    for (int i = 0; i < 4; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void insertionSort(int[] arr) {
    int k = 0;
    while (k < arr.length) {
      int i = k;
      while (i > 0 && arr[i - 1] > arr[i]) {
        int temp = arr[i - 1];
        arr[i - 1] = arr[i];
        arr[i] = temp;
        i--;
      }
      k++;
    }
  }

}