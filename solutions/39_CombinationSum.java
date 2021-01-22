/* Backtracking Problem
   Backtracking is a general algorithm for finding all (or some) solutions to
   some computational problems, notably constraint satisfaction problems,
   that incrementally builds candidates to the solutions, and abandons a candidate
   ("backtracks") as soon as it determines that the candidate cannot possibly
   be completed to a valid solution.

   Pseudocode of backtracking problem:
   if the partial candidate cannot be completed to a valid solution
      return
   if the partial candidate is a valid solution
      add the candidate to solutions
      return
   else
      incrementally build candidates
      call the function recursively with updated parameter

   In this question:
   Hold a list of integer (partial candidate),
   Check if it is possible to reach the target or if it is a valid solution,
   Update the target value and recursively call the backtracking function */

   class Solution {
       public List<List<Integer>> combinationSum(int[] candidates, int target) {
           // Hold all the solutions
           List<List<Integer>> ans= new ArrayList<>();

           // Hold the partial candidate
           List<Integer> possibleCombination= new ArrayList<>();

           Arrays.sort(candidates);

           findCombinationToTarget(ans, possibleCombination, candidates, target, 0);
           return ans;
       }

       // Backtracking function
       private void findCombinationToTarget(List<List<Integer>> ans,
                                            List<Integer> possibleCombination,
                                            int[] candidates, int target,
                                            int startIndex) {
           // Check if the current partial candidate can achieve the target
           // Since candidates >= 1, if target < 0, impossible to reach
           if (target < 0) {
               return;
           }
           // Check if the current candidate is a valid solution
           if (target == 0) {
               // If so, add the candidate to solutions
               // Cannot directly add possibleCombination because it is a reference variable
               ans.add(new ArrayList<>(possibleCombination));
               return;
           }
           // If the candidate is not a valid solution yet and can still add
           // element to it
           for (int i= startIndex; i < candidates.length && candidates[i] <= target; i++) {
               // Add a new element to the candidate
               possibleCombination.add(candidates[i]);
               // Recursive call
               // now the target = original target - value of newly added element
               findCombinationToTarget(ans, possibleCombination, candidates, target-candidates[i], i);
               // Last Line finished execution when
               // 1. the target value become negative - the newly added element is too large
               // 2. the candidate is a valid solution
               // In either case, we need to remove the last element in the partial candidate
               possibleCombination.remove(possibleCombination.size()-1);
           }
       }
   }
