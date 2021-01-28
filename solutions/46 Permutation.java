/* Idea:
   Recursion. When computing permutation of array nums[0..n] elements, we first
   compute the permutation of nums[0..n-1]. Then, we put nums[n] at all possible
   position of the previous permutation. */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permuteHelper(0, nums.length - 1, nums);
    }

    private List<List<Integer>> permuteHelper(int start, int end, int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();

        if (start > end) return ans;

        if (start == end) {
            List<Integer> p= new ArrayList<>();
            p.add(nums[start]);
            ans.add(p);
            return ans;
        }

        List<List<Integer>> prev = permuteHelper(start, end - 1, nums);
        for (List<Integer> list: prev){
            int len = list.size();
            for (int i=0; i<=len; i++) {
                List<Integer> p= new ArrayList<>(list);
                p.add(i, nums[end]);
                ans.add(p);
            }
        }

        return ans;
    }
}
