/* Crucial Insights:
   1. For an Array with length n, the first missing positive integer x is in
      range 1 <= x <= n+1
      Therefore, we do not care any negative number and any number that is larger
      than n.
      Also, the index of the array can represent first missing positive integer
      (be careful that index range starts from 0 but first missing positive
      integer starts from 1)
   2. If all the elements in Array is positive, we can use the negative of the
      stored value in that element as a flag to mark something.


   Idea:
   1. First Loop
      change all negative numbers and numbers larger than length to 1
   2. Second Loop
      Get the value v of the element, transform it into index form i = v-1, get
      the element on that i and change it to a negative value
      -> mark that v= i+1 has appeared in the array
   3. Third Loop
      Find the index of the first non-negative element (non-negative meaning the
      value index+1 has not appeared in the array) */

      class Solution {
          public int firstMissingPositive(int[] nums) {
              int len= nums.length;
              // Since we set all the unimportatn integer to 1, we need to check
              // if the original array contains 1 (if not, setting these value
              // to 1 can mess things up)
              boolean containsOne= false;

              // First Loop
              for (int i=0; i<len; i++) {
                  if (nums[i] == 1) containsOne = true;
                  else if (nums[i] <= 0 || nums[i] > len) {
                      nums[i] = 1;
                  }
              }

              // If the array does not contain 1, the first missing positive
              // integer is 1. So we return 1 immediately
              if (!containsOne) return 1;

              // Second Loop
              for (int j=0; j<len; j++) {
                  // We need to use absolute value of element because we may
                  // have already mark the index of it by changing it into the
                  // negative value
                  int numToIndex = Math.abs(nums[j]) - 1;
                  if (nums[numToIndex] > 0) {
                      nums[numToIndex] = -1 * nums[numToIndex];
                  }
              }

              // Third Loop
              for (int k=0; k<len; k++) {
                  if (nums[k] > 0) return k + 1;
              }

              // If all elements in the array are negative, it means that integer
              // 1..len has all appeared in the array
              return len+1;
          }
      }
