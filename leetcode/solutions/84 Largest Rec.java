public class LargestRec {

  public int largestRectangleArea(int[] heights) {
    int[] mostLeftBar = new int[heights.length];
    int[] mostRightBar = new int[heights.length];
    mostLeftBar[0] = -1;
    mostRightBar[heights.length - 1] = heights.length;

    for (int i = 1; i < heights.length; i++) {
      int left = i - 1;
      while (left >= 0 && heights[left] >= heights[i]) {
        left = mostLeftBar[left];
      }
      mostLeftBar[i] = left;
    }

    for (int i = heights.length - 2; i >= 0; i--) {
      int right = i + 1;
      while (right < heights.length && heights[right] >= heights[i]) {
        right = mostRightBar[right];
      }
      mostRightBar[i] = right;
    }

    int res = Integer.MIN_VALUE;
    for (int i = 0; i < heights.length; i++) {
      res = Math.max(res, (mostRightBar[i] - mostLeftBar[i] - 1) * heights[i]);
    }
    return res;

  }

}
