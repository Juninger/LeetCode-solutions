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
    public boolean isValidSudoku(char[][] board) {
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
