class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int pointer1 = m - 1;
    int pointer2 = n - 1;
    int pointer = m + n - 1;

    while (pointer >= 0 && pointer2 >= 0 && pointer1 >= 0) {
      if (nums1[pointer1] > nums2[pointer2]) {
        nums1[pointer] = nums1[pointer1];
        pointer1--;
      } else {
        nums1[pointer] = nums2[pointer2];
        pointer2--;
      }
      pointer--;
    }

    while (pointer2 >= 0) {
      nums1[pointer] = nums2[pointer2];
      pointer2--;
      pointer--;
    }
  }
}