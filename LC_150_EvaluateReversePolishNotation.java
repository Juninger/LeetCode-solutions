import java.util.Stack;

/**
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 * Evaluate the expression. Return an integer that represents the value of the expression.
 *
 * Note that:
 * - The valid operators are '+', '-', '*', and '/'.
 * - Each operand may be an integer or another expression.
 * - The division between two integers always truncates toward zero.
 * - There will not be any division by zero.
 * - The input represents a valid arithmetic expression in a reverse polish notation.
 * - The answer and all the intermediate calculations can be represented in a 32-bit integer.
 */
public class LC_150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) { // iterate input
            switch (token) { // if current token is an operator, perform the corresponding calculation
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int sub1 = stack.pop();
                    int sub2 = stack.pop();
                    stack.push(sub2 - sub1);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int div1 = stack.pop();
                    int div2 = stack.pop();
                    stack.push(div2 / div1);
                    break;
                default: // token is not an operator, add number to stack
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop(); // contains our final expression
    }
}