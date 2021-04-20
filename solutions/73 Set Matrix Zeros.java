class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[][] originalZero = new boolean[matrix.length][matrix[0].length];

        for (int r=0; r<matrix.length; r++){
            for (int c=0; c<matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    originalZero[r][c] = true;
                }
            }
        }

        for (int r=0; r<matrix.length; r++){
            for (int c=0; c<matrix[0].length; c++) {
                if (matrix[r][c] == 0 && originalZero[r][c] == true) {
                    for (int i=0; i<matrix.length; i++){
                        matrix[i][c] = 0;
                    }
                    for (int j=0; j<matrix[0].length; j++){
                        matrix[r][j] = 0;
                    }
                }
            }
        }
    }
}
