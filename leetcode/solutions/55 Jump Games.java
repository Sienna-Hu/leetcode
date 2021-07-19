class Solution {
    /** My solution:
        When encountering 0 that is not on the last index, determine if we can jump over
        this position. */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        if (nums[0] == 0) return false;

        for (int i=0; i < nums.length-1; i++) {
            if (nums[i] == 0) {
                int j = i-1;
                int gap = 1;
                while (j >= 0) {
                    if (nums[j] > gap) {
                        break;
                    } else {
                        gap++;
                        j--;
                    }
                }
                if (j < 0) return false;
            }
        }

        return true;
    }

    /** Greedy algorithm:
        A position is a "good index" if starting at that position, we can reach
        the last index. Otherwise, that index is called a "bad index".
        The problem then reduces to whether or not index 0 is a "good index".
        Iterating from the end to the start:
          Index n-1 is good index.
          Index n-2 is good index if on n-2 we can reach n-1
            i.e. if nums[n-2] > 1, or alternatively if nums[n-2] + n-2 > n-1
          and so on... */
    public boolean canJump(int[] nums) {
        int lastGoodIndexPosition = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= lastGoodIndexPosition) {
                lastGoodIndexPosition = i;
            }
        }

        return lastGoodIndexPosition == 0;
   }
}
