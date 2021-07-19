// Binary Search Iteratively: use two pointer (lo and hi) and update lo/hi based
// on whether nums[mid] > target.

// Idea:
// In this question, we need to find the starting and ending position of a given
// target value. Therefore, when search for a target, we need an additional
// argument determine whether we want the left most target or right most target.

// Notes:
// Be careful when potential index out of range

// Help function: find the leftmost and rightmost index where the target
// should be inserted in sorted array nums.
private int extremeInsertionIndex(int[] nums, int target, boolean left) {
  int lo = 0;
  int hi = nums.length;

  while (lo < hi) {
    int mid = (lo + hi) / 2;
    if (nums[mid] > target || (left && target == nums[mid])) {
      hi = mid;
    }else {
      lo = mid+1;
    }
  }

  return lo;
}

// Main function: time complexity O(n)
public int[] searchRange(int[] nums, int target) {
  // Initialize the answer to default value
  int range = new int[] {-1, -1};

  int left= extremeInsertionIndex(nums, target, true);
  int right= extremeInsertionIndex(nums, target, false);

  // If target is not in nums
  // 1. left == nums.length: need to handle separately because cannot reference nums[left]
  // 2. nums[left] != target
  if (left >= nums.length || (nums[left] != target)) return range;

  range[0]=left;
  range[1]=right-1;

  return range;
}
