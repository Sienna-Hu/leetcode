/* Notes:
   1. The power n may be negative:
      Do not need a boolean variable to hold whether it is negative. x^-n = 1/x^n = (1/x)^n
   2. Be careful with the Integer.MIN_VALUE and Integer.MAX_VALUE here since we
      tranform negative integer to positive.
      - Integer.MIN_VALUE > Integer.MAX_VALUE, causing overflow problem. */

class Solution {
    public double myPow(double x, int n) {
        if (n==0) return 1;
        if (n==1) return x;

        double ans = 1;

        if (n == Integer.MIN_VALUE) {
            x = x*x;
            // Effectively reduce n to avoid overflow problem
            n= n/2;
        }

        if (n < 0) {
            x= 1/x;
            n= -n;
        }

        if (n%2==0) {
            ans= myPow(x*x, n/2);
        } else {
            ans= x * myPow(x*x, (n-1)/2);
        }

        return ans;
    }
}
