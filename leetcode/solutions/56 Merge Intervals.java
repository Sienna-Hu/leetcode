class Solution {
    /** My solution:
        start1 = intervals[0][0], end1 = interval[0][1]
        Compare the interval with all other intervals respectively.
            start2 = interval[j][0], end2 = interval[j][1]
            If start1 < end2 && end1 > start2, they are overlapping.
            start1 = Math.min(start1, start2), end1 = Math.max(end1, end2)
            Remove interval[j]
        Add [start1, end1] to the ans list.

        Mistakes:
        1. Did not sort intervals.
            e.g. [[2,3], [4,5], [6,7], [8,9], [1,10]]
            Start from [2,3]. Iterate through the following interval and we
            change [2,3] into [1,10]. Remove [1,10]. Add [1, 10] to the ans list.
            We move to next interval [4,5]. We will not compare [4,5] and [1,10]
            now though they are actually overlapping.
            -> If intervals are sorted based on the "start", there will not be
            the case that the following intervals cover entire previous intervals.

        Note:
        1. Arrays.sort(array, anonymous function)
           anonymous function: (a, b) -> Integer.compare(a[0], b[0])
        2. Array to ArrayList
           new ArrayList<>(array.length)
           Collections.addAll(arrayList, array)
        3. ArrayList to Array
           arrayList.toArray(new array[arrayList.size()])

        */
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> intervalsAL = new ArrayList<>(intervals.length);
        Collections.addAll(intervalsAL, intervals);

        int i=0;
        while(i < intervalsAL.size()) {
            int start = intervalsAL.get(i)[0];
            int end = intervalsAL.get(i)[1];

            int j= i+1;
            while (j < intervalsAL.size()) {
                if (start <= intervalsAL.get(j)[1] && end >= intervalsAL.get(j)[0]) {
                    end = Math.max(end, intervalsAL.get(j)[1]);
                    intervalsAL.remove(j);
                    j--;
                }
                j++;
            }

            ans.add(new int[]{start, end});
            i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }

    /** Improvement:
        1. After sorting, no need of two while loop.
        First initialize newInterval as intervals[0] and add it to the ans.
        Iterate through all the following interval.
        If current interval[1] <= newInterval[0] -> overlapping
          -> update the end (no need to update start because sorted based on start)
        If current interval is disjoint with newInterval -> the following intervals
        that hasn't been iterated has a start at least as larger as current interval,
        suggesting that they will not overlap with newInterval. Thus, we will not
        update current newInterval. We can set newInterval to current interval
        and update that.
        Idea here:
        - Do not need to delete element in arrays, just move to the next element. */
    public int[][] merge2(int[][] intervals) {
		    if (intervals.length <= 1) return intervals;

		    // Sort by ascending starting point
		    Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

		    List<int[]> result = new ArrayList<>();
		    int[] newInterval = intervals[0];
		    result.add(newInterval);

		    for (int[] interval : intervals) {
             // Overlapping intervals, move the end if needed
			       if (interval[0] <= newInterval[1]) {
  				       newInterval[1] = Math.max(newInterval[1], interval[1]);
             }
             // Disjoint intervals, add the new interval to the list
             // After sorting, when encounter disjoint intervals, means the
             // following intervals are also disjoint with current newInterval
             // -> new setup
			       else {
				         newInterval = interval;
				         result.add(newInterval);
			       }
		    }

		    return result.toArray(new int[result.size()][]);
	  }
}
