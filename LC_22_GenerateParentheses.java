import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 */
public class LC_22_GenerateParentheses {

    List<String> result = new ArrayList<>(); // stores finished combinations of well-formed parentheses
    StringBuilder sb = new StringBuilder(); // used as a "pseudo-stack" to store parentheses

    // driver method to start recursion
    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return result;
    }

    // recursive method which tracks conditions for building valid parentheses combinations
    public void backtrack(int open, int closed, int n) {
        if (open == n && closed == n) { // finished (all opening and closing parentheses used), StringBuilder contains our proper parentheses
            result.add(sb.toString());
            return;
        }

        // recursive part
        if (open < n) { // we can add more opening parentheses
            sb.append("("); // add opening parentheses
            backtrack(open + 1, closed, n); // backtrack and add +1 to count of opening parentheses
            sb.deleteCharAt(sb.length() - 1); // clean up "stack" to try other possibilities
        }
        if (closed < open) { // we can add more closing parentheses
            sb.append(")"); // add closing parentheses
            backtrack(open, closed + 1, n); // backtrack and add +1 to count of closing parentheses
            sb.deleteCharAt(sb.length() - 1); // clean up "stack" to try other possibilities
        }
    }
}
