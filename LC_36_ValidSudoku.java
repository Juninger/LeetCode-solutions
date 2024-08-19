import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */
class LC_36_ValidSudoku {
    // brute-force solution to check rows->cols->subBoxes individually
    public boolean isValidSudoku(char[][] board) {

        // check rows for duplicates
        for (int row = 0; row < 9; row++) {
            Set<Character> rowSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[row][j] == '.') continue; // empty square
                if (rowSet.contains(board[row][j])) return false; // duplicate found
                rowSet.add(board[row][j]);
            }
        }

        // check columns for duplicates
        for (int col = 0; col < 9; col++) {
            Set<Character> colSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][col] == '.') continue; // empty square
                if (colSet.contains(board[j][col])) return false; // duplicate found
                colSet.add(board[j][col]);
            }
        }

        // check 3x3 sub-boxes for duplicates
        for (int boxRowStart = 0; boxRowStart < 9; boxRowStart += 3) { // iterate starting points of each 3x3 sub-box
            for (int boxColStart = 0; boxColStart < 9; boxColStart += 3) {
                Set<Character> subBox = new HashSet<>();
                for (int i = 0; i < 3; i++) { // rows in sub-box
                    for (int j = 0; j < 3; j++) { // columns in sub-box
                        char curr = board[boxRowStart + i][boxColStart + j];
                        if (curr == '.') continue; // empty square
                        if (subBox.contains(curr)) return false; // duplicate found
                        subBox.add(curr);
                    }
                }
            }
        }
        return true; // valid sudoku
    }

    // more optimized solution from NeetCode
    public boolean isValidSudoku2(char[][] board) {
        Map<Integer, Set<Character>> rowSet = new HashMap<>();
        Map<Integer, Set<Character>> colSet = new HashMap<>();
        Map<Integer, Set<Character>> subBox = new HashMap<>();

        for (int row = 0; row < 9; row++) { // iterate rows
            for (int col = 0; col < 9; col++) { // iterate columns

                if (board[row][col] == '.') continue; // empty square

                char c = board[row][col]; // current character

                // combines row and col value to create a unique key for every sub-box on the board
                int boxKey = (row / 3) * 3 + (col / 3);

                // initialize sets to avoid null pointers
                rowSet.putIfAbsent(row, new HashSet<>());
                colSet.putIfAbsent(col, new HashSet<>());
                subBox.putIfAbsent(boxKey, new HashSet<>());

                // check if sets already contains the current character
                if (rowSet.get(row).contains(c) ||
                    colSet.get(col).contains(c) ||
                    subBox.get(boxKey).contains(c)
                ) return false;

                // add current character to sets
                rowSet.get(row).add(c);
                colSet.get(col).add(c);
                subBox.get(boxKey).add(c);
            }
        }
        return true;
    }
}
