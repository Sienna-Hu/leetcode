class Solution {
  public void sortColors(int[] nums) {
      int left = 0;
      int right = nums.length - 1;
      
      for (int i = 0; i <= right; i++) {
          while (nums[i] == 2 && i < right) {
              swap(nums, i, right);
              right--;
          }
          while (nums[i] == 0 && i > left) {
              swap(nums, i, left);
              left++;
          }
      }
  }
  
  private void swap(int[] nums, int left, int right) {
      int temp = nums[left];
      nums[left] = nums[right];
      nums[right] = temp;
  }
}