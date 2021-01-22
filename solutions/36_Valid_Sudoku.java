// Use HashSet when encountering situations to determine unique values
// The add function return true when successfully add, false otherwise

// Idea:
// Hold a HashSet<Integer> for every rows, columns, and sub_boxes of the sudoku
// board. (Use Integer here because it is a narrower type than char -> save space)


class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 每一个row/col/sub_box都需要一个HashSet -> 一共需要9个HashSet for row/col/sub_box
        // Use array to store HashSet for each row/col/sub_box
        HashSet<Integer>[] rows = new HashSet[9];
        HashSet<Integer>[] cols = new HashSet[9];
        HashSet<Integer>[] boxes = new HashSet[9];

        // Initialize every HashSet
        for (int i=0; i<9; i++) {
            rows[i]= new HashSet<Integer>();
            cols[i]= new HashSet<Integer>();
            boxes[i]= new HashSet<Integer>();
        }

        // Iterate through every element
        // Don't need to worry about time complexity as the input size is fixed
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char currC= board[i][j];
                if (currC != '.') {
                    // Determine which sub_box the element belongs to
                    int box_index = i/3 + (j/3)* 3;
                    // Convert the element into int to save space
                    int curr= (int) currC;

                    // Attempt to add curr into the row/col/sub_box it belongs
                    // Failure to add means duplicates -> return false
                    if (!rows[i].add(curr) || !cols[j].add(curr) || !boxes[box_index].add(curr)) {
                        return false;
                    }

                }
            }
        }
        return true;
    }
}

// Space Complexity Improvement:
// Use one single HashSet<String> to hold all the information of the current element
// e.g. 针对一个curr有三个信息:
//      curr + "found at row" + i,
//      curr + "found at col" + j,
//      curr + "found at box" + i/3+j/3*3
//      These three won't affect each other due to different string information
//      However, if in the same row/col/sub_box, there is duplicates, it cannot
//      be successfully added to the HashSet -> return false
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> val_info= new HashSet<>():

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char currC= board[i][j];
                if (currC != '.') {
                    // Determine which sub_box the element belongs to
                    int box_index = i/3 + (j/3)* 3;
                    // Convert the element into int to save space
                    int curr= (int) currC;

                    // Attempt to add curr into the row/col/sub_box it belongs
                    // Failure to add means duplicates -> return false
                    if (!val_info.add(curr + "found at row" + i)
                    || !val_info.add(curr + "found at col" + j)
                    || !val_info.add(curr + "found at box" + i/3+j/3*3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
