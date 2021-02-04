class Solution {
    /** My solution:
        Everytime increment by 1 -> Time complexity O(n)
        */
    public int mySqrt(int x) {
        if (x == 0) return 0;

        int sqrt = 1;

        while (sqrt*sqrt <= x) {
            if (sqrt == 46340) {
                return sqrt;
            }
            sqrt++;
        }

        return sqrt-1;
    }

    /** Improvement:
        Binary search -> Time complexity O(nlogn). */
    public int mySqrt(int x) {
		    long i = 0;
		    long j = x;

		    while (i <= j) {

			       long mid = i + ((j - i) / 2);

			       long sq = mid * mid;

			       if (sq == x) {
				           return (int) mid;
			       } else if (sq > x) {
				           j = mid - 1;
			       } else {
				           i = mid + 1;
			       }

		    }

		    return (int) (i - 1);

  	}
}
