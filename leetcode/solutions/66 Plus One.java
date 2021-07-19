class Solution {
    public int[] plusOne(int[] digits) {
        int last = digits.length - 1;
        // If last digit is not 9, simply add 1
        if (digits[last] != 9) {
            digits[last]++;
            return digits;
        }

        // If last digit is not 9, loop from end to start until encounter the
        // first number that is not 9
        int curr = last;
        while (curr >= 0 && digits[curr] == 9) {
            digits[curr] = 0;
            curr--;
        }

        // If curr is not -1, add one to current value and return
        if (curr > -1) {
            digits[curr]++;
            return digits;
        }

        int[] ans = new int[last+2];
        ans[0] = 1;
        for (int i=0; i<=last; i++){
            ans[i+1] = digits[i];
        }

        return ans;

    }
}
