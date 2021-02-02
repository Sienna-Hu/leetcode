class Solution {
    /** My solution */
    public List<Integer> spiralOrder(int[][] matrix) {
        int c = 0;
        int row_num = matrix.length;
        int col_num = matrix[0].length;

        // Use these three boolean variables to determine the direction
        boolean prevRow = false;
        boolean oddRow = true;
        boolean oddCol = true;
        // Use these four int variables to keep track of the start and the end
        int row_end = col_num - 1;
        int row_start = 0;
        int col_end = row_num - 1;
        int col_start = 1;
        List<Integer> ans = new ArrayList<>();

        while (c < row_num * col_num) {
            if (!prevRow && oddRow) {
                for (int i = row_start; i <= row_end; i++) {
                    ans.add(matrix[col_start - 1][i]);
                    c++;
                }
                prevRow = true;
                oddRow = false;
                int temp1 = row_start;
                row_start = row_end - 1;
                row_end = temp1;
            }
            else if (prevRow && oddCol) {
                for (int i = col_start; i <= col_end; i++) {
                    ans.add(matrix[i][row_start + 1]);
                    c++;
                }
                prevRow = false;
                oddCol = false;
                int temp2 = col_start;
                col_start = col_end - 1;
                col_end = temp2;
            }
            else if (!prevRow && !oddRow) {
                for (int i = row_start; i >= row_end; i--) {
                    ans.add(matrix[col_start + 1][i]);
                    c++;
                }
                prevRow = true;
                oddRow = true;
                int temp3 = row_start;
                row_start = row_end + 1;
                row_end = temp3;
            }
            else {
                for (int i = col_start; i >= col_end; i--){
                    ans.add(matrix[i][row_start - 1]);
                    c++;
                }
                prevRow = false;
                oddCol = true;
                int temp4 = col_start;
                col_start = col_end + 1;
                col_end = temp4;
            }
        }

        return ans;
    }

    /** Improvement:
        1. Do not need three boolean variables to determine the direction.
           Instead, use an int variable dir.
           0 -> left to right; 1 -> top to down; 2 -> right to left; 3 -> down to top
        2. Do not need to switch start and end (name are misleading)
           Call them top, down, left, right
           As we can see from my solution code, after we moved along a layer,
           we only change one value of start and end, the other remains the same.
        3. Do not need to count how many elements how many elements we have added.
           As long as top <= down && left <= right, there are elements haven't
           been iterated.
      */
      public List<Integer> spiralOrder2(int[][] matrix) {
        int dir = 0;
        int right = matrix[0].length - 1;
        int left = 0;
        int down = matrix.length - 1;
        int top = 0;
        List<Integer> ans = new ArrayList<>();

        while (left <= right && top <= down) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    ans.add(matrix[top][i]);
                }
                top++;
                dir = 1;
            }
            else if (dir == 1) {
                for (int i = top; i <= down; i++) {
                    ans.add(matrix[i][right]);
                }
                right--;
                dir = 2;
            }
            else if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[down][i]);
                }
                down--;
                dir = 3;
            }
            else {
                for (int i = down; i >= top; i--){
                    ans.add(matrix[i][left]);
                }
                left++;
                dir = 0;
            }
        }

        return ans;
    }
}
