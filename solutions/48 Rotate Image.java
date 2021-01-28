/* My Idea:
   Clockwisely rotate a matrix means move matrix[i][j] to position
   matrix[j][n-1-i].
   In order to avoid move element that is already in the correct position, we
   use another matrix to record whether the element in that position is correct.

   Time complexity: O(M)
   Space complexity: O(M) - additional matrix for whether it is in the correct
   position.
   */

class Solution {
    public void rotate1(int[][] matrix) {
        int n= matrix.length;
        int n_index = n-1;
        boolean[][] rightPosition = new boolean[n][n];

        for (int i=0; i< n; i++) {
            for (int j=0; j< n; j++) {
                if (rightPosition[i][j] == false) {
                    int temp = matrix[j][n_index-i];
                    matrix[j][n_index-i] = matrix[i][j];
                    matrix[i][j] = temp;
                    rightPosition[j][n_index-i] = true;
                }
            }
        }
    }

    /* Improvement:
       We rotate four elements at a cycle:
       (i, j) -> (j, n-1-i) -> (n-1-i, n-1-j)-> (n-1-j, i) -> (i, j)
       */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        // Set the upper limit of i and j so that it will not rotate the same
        // 4 elements -> space complexity reduced to O(1)
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    /* Another idea: rotate clockwisely by 90 degrees = first transpose and
       then switch left and right column. */
    public void rotate3(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    public void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
}
