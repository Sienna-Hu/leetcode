/* The idea of division can be converted to substraction problem. Quotient means
   how many divisors we can substract from dividend. Therefore, the trick here
   is to keep substract divisor from the dividend until dividend is smaller than
   the divisor. Keep track of how many divisors we have substracted and that is
   the quotient */

/** Basic Solution: Time complexity: O(n), n represents quotient size */
class Solution {
    public int divide(int dividend, int divisor) {
        // Handle Overflow: Range [-2^31, 2^31-1], negative part has one more value,
        // converting to positive causes overflow problems
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        // Handle the largest case to save some time (otherwise will reach time limit)
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;

        // Keep track of the sign of the final result
        boolean negative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        // Convert dividend and divisor to same sign to reduce unnecessary case considerations
        // Notes: Convert to negative because if dividend == Integer.MIN_VALUE, convert to positive cause overflow problems
        dividend = dividend < 0 ? dividend : -dividend;
        divisor = divisor < 0 ? divisor : -divisor;

        int quotient=0;
        // Since dividend and divisor are all negative, when dividend is larger
        // than divisor, it means we cannot substract divisor from dividend (will
        // make dividend > 0).
        while (dividend <= divisor) {
            dividend -= divisor;
            quotient++;
        }

        return negative ? -quotient : quotient;

    }
}

/** Improvement: substract multiple divisor from dividend each time to reduce
the execution time of while loop */
class Solution {
    public int divide2(int dividend, int divisor) {
        // Handle Overflow: Range [-2^31, 2^31-1], negative part has one more value,
        // converting to positive causes overflow problems
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        // Handle the largest case to save some time (otherwise will reach time limit)
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;

        // Keep track of the sign of the final result
        boolean negative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        // Convert dividend and divisor to same sign to reduce unnecessary case considerations
        // Notes: Convert to negative because if dividend == Integer.MIN_VALUE, convert to positive cause overflow problems
        dividend = dividend < 0 ? dividend : -dividend;
        divisor = divisor < 0 ? divisor : -divisor;

        // Example: -63/-2 -> -4 > -8 > -16 > -32 ->
        int quotient=0;
        while (dividend <= divisor) {
            int count=1;
            int accum=divisor;
            // >> 1 is a bitwise operation, meaning right shift (it essentially reduce the value by half)
            while (accum >= Integer.MIN_VALUE >> 1 && dividend <= accum+accum) {
              //Example:
                //1st round: -2 -> -4
                //2nd round: -4 -> -8
                //...
                //final round: -16 -> -32
              accum+= accum;
              //Example:
                //1st round: 1 divisor -> 2 divisor
                //2nd round: 2 divisor -> 4 divisor
                //...
                //final round: 8 divisor -> 16 divisor
              count+= count;
            }
            dividend-= accum;
            quotient+= count;
        }
        return negative ? -quotient : quotient;

    }
}
