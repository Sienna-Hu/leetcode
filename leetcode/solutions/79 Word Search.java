public class 79WordSearch {
  public boolean exist(char[][] board, String word) {
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        // need a backtrack helper function for recursive call
        if (checkExist(board, word, 0, row, col)) {
          return true;
        }
      }
    }

    return false;
  }

  public boolean checkExist(char[][] board, String word, int curr, int row, int col) {
    if (curr >= word.length()) {
      return true;
    }

    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '0'
        || board[row][col] != word.charAt(curr)) {
      return false;
    }

    char temp = board[row][col];
    board[row][col] = '0';

    if (checkExist(board, word, curr + 1, row + 1, col) || checkExist(board, word, curr + 1, row, col + 1)
        || checkExist(board, word, curr + 1, row - 1, col) || checkExist(board, word, curr + 1, row, col - 1)) {
      return true;
    }

    board[row][col] = temp;

    return false;

  }
}
