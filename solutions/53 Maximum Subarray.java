/* Dynamic Programming:
   Dynamic Programming (DP) is an algorithmic technique for solving an
   optimization problem by breaking it down into simpler subproblems and
   utilizing the fact that the optimal solution to the overall problem depends
   upon the optimal solution to its subproblems.

   Idea:
   Subproblem here is maxSubArray(int[] nums, int endIdx), which returns the
   maxSubArray value for nums[0..endIdx]
   Then the global problem is maxSubArray(nums, nums.length - 1)
   e.g.
      index =  0  1   2  3   4  5  6   7  8
      nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

      Iterate through each index of nums:
        maxSubArray(nums, 0) is [-2, sum = -2]
        maxSubArray(nums, 1) is [1, sum = 1] since 1 > -2 + 1
        maxSubArray(nums, 2) is [1, -3, sum = -2] since 1 + -3 > -3
        ...
        we need to know the previous maxSubArray sum to compute the current
        maxSubArray sum

      Compare maxSubArray values at each index, the largest one is the answer

   */

class Solution {
    public int maxSubArray(int[] nums) {
        int globalMax = nums[0];
        int currMax = nums[0];

        for (int i=1; i< nums.length; i++) {
            currMax = Math.max(currMax + nums[i], nums[i]);
            gloabalMax = Math.max(gloabalMax, currMax);
        }

        return max;
    }
}
