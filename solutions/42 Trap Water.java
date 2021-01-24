/* General ways of thinking algorithm
   1. Analyze the question: how my brain think of the problem
   2. Follow my brain's idea to develop the brute force algorithm (Pseudocode)
   3. Optimize the algorithm: redundant work?

   Idea for this question:
   1. Total water trapped = sum of water trapped at each index
   2. Water trapped at each index = the minimum (the highest wall on the left
      and the highest wall on the right) - the wall height at the index */

class Solution {
    /** The most basic solution
        Time Complexity: O(n^2)
        Space Complexity: O(1) */
    public int trap(int[] height) {
        int totalWater= 0;

        for (int i=0; i< height.length; i++) {
            int leftMax= height[i];
            for (int j=0; j< i; j++) {
                if (height[j] > leftMax) leftMax= height[j];
            }

            int rightMax= height[i];
            for (int k=i+1; k< height.length; k++) {
                if (height[k] > rightMax) rightMax= height[k];
            }

            totalWater+= Math.min(leftMax, rightMax) - height[i];
        }

        return totalWater;
    }


/* In the most basic solution, we iterate through the whole array for each index
   position to determine the highest wall on the left and on the right.
   However, when moving from index i to i+1, we can find the highest wall on the
   left by comparing the wall at index i+1 and the highest wall on the left of
   wall on index i (highest wall on the right is similar)
   Therefore, keep a record of the highest wall on the left(right) of each index
   so that we do not need to iterate through the whole array again for each index
   to find the left and right highest wall -> reduce time complexity. */

   /** Reduced time complexity by keep a record of the left highest wall and the
       right highest wall.
       Time complexity O(n)
       Space complexity O(n) */
   public int trap(int[] height) {
        // Base case
        if (height.length < 3) return 0;

        int totalWater= 0;
        int len= height.length;

        // Iterate through the array to record the highest wall on the left of
        // position i
        int[] leftMax= new int[len];
        leftMax[0]= height[0];
        for (int i=1; i< len; i++) {
            leftMax[i]= Math.max(height[i], leftMax[i-1]);
        }
        // Iterate through the array to record the highest wall on the right of
        // position i
        int[] rightMax= new int[len];
        rightMax[len-1]= height[len-1];
        for (int i=len-2; i>= 0; i--) {
            rightMax[i]= Math.max(height[i], rightMax[i+1]);
        }

        // Iterate through the array to sum up all the water trapped
        for (int i=0; i< len; i++) {
            totalWater+= Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return totalWater;
    }

/* Although we reduced the time complexity to O(n), we increase the space
   complexity to O(n). Can we know the minimum of the highest wall on the left
   of position i and the highest wall on the right of position i without save
   their value in an array?

   Idea here: 
   The highest wall on the left of position i is unchange or increase as i increase.
   The highest wall on the right of position i is unchange or increase as i decrease.
   Use two pointers i and j:
      i goes from 0 to n wherease j goes from n to 0
      Assume the highest wall on the left of i is smaller than the highest wall
      on the right of j.
      The highest wall on the right of i must be larger than the highest wall
      on the right of j.
      Hence, the minimum of the highest wall on the left and the right of i is
      the highest wall on the left of i.
   From there, we directly obtain the minimum of the highest wall on the left and
   the right of i. */

   /** Reduced space complexity
       Time complexity O(n)
       Space complexity O(1) */
   public int trap(int[] height) {
           int len= height.length;
           if (len < 3) return 0;

           int totalWater= 0;

           int i= 0;
           int j= len-1;

           int leftMax= height[0];
           int rightMax= height[len-1];

           while (i <= j) {
               leftMax= Math.max(leftMax, height[i]);
               rightMax= Math.max(rightMax, height[j]);
               if (leftMax < rightMax) {
                   totalWater+= leftMax - height[i];
                   i++;
               } else {
                   totalWater+= rightMax - height[j];
                   j--;
               }
           }


           return totalWater;
       }

}
