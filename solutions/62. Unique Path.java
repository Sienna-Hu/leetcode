/* Idea:
   When recursive call goes too deep, it costs a lot of time.
   Convert recursie call to a problem about filling the matrix. */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++)
            paths[i][0] = 1;
        for (int j = 0; j < n; j++)
            paths[0][j] = 1;
        for (int k = 1; k < paths.length; k++)
            for (int l = 1; l < paths[0].length; l++)
                paths[k][l] = paths[k-1][l] + paths[k][l-1];
        return paths[m-1][n-1];
    }
}
