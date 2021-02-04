class Solution {
    /** Brute force recursion.
        Problem: when executing climbStairs1(n-1), we have already executing
        climbStairs1(n-2). But we did not store the value. So we need to execute
        climbStairs1(n-2) again -> redundant work. */
    public int climbStairs1(int n){
      if (n==1) return 1;
      if (n==2) return 2;
      return climbStairs1(n-1)+climbStairs2(n-1);
    }
    /** My solution:
        Time complexity: O(n)
        Space complexity: O(n). */
    public int climbStairs2(int n) {
        if (n == 1) return 1;

        int[] hold = new int[n];
        hold[0] = 1;
        hold[1] = 2;

        for (int i=2; i<n; i++) {
            hold[i] = hold[i-1]+hold[i-2];
        }

        return hold[n-1];
    }

    /** Improvement:
        Reduce space complexity to O(1) as we only need previous 2 elements. We
        do not need to store all the previous answers. Instead, we can keep
        updating previous 2 elements. */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
