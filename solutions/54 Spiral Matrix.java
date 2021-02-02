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
           we only change one value of start and end, the other remains the same
      */
}
