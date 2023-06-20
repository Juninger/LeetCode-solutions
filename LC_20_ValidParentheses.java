import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class LC_20_ValidParentheses {
    public boolean isValid(String s) {

        // Stack used to store opening parentheses and brackets
        Deque<Character> stack = new ArrayDeque<>();
        // We can use ArrayDeque as a stack because we don't need synchronization

        // Collection of individual opening/closing parentheses and brackets ( ) { } [ ]
        char[] chars = s.toCharArray();

        /*
        General idea:
        - Iterate all characters:
        - If opening character, push to stack
        - If stack is empty during loop, a closing characters is missing --> return false
        - If closing character, check if it forms a valid pair with the top of the stack:
            valid --> pop from stack
            not valid --> return false
        - If stack is empty after the loop is finished, all pairs are valid
         */
        for (char c : chars) {

            // Checks for opening characters
            if (c == '(' || c == '{' || c == '[') {

                stack.push(c);

            } else {

                // Checks for valid pair between current character and top of stack
                if (stack.isEmpty() ||
                    !( (c == ')' && stack.peek() == '(')
                    || (c == '}' && stack.peek() == '{')
                    || (c == ']' && stack.peek() == '[') )) {
                    return false;
                }

                stack.pop(); // Valid pair found
            }
        }

        return stack.isEmpty();
    }
}
