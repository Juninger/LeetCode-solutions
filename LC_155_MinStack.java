import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 *
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class LC_155_MinStack {

    Deque<Integer> stack = new ArrayDeque<>(); // stores all values
    int min = Integer.MAX_VALUE; // tracks the min value outside of stack

    public LC_155_MinStack() {} //empty default constructor

    public void push(int val) {
        if (val <= min) {
            stack.push(min); // adds the OLD min value to the stack
            min = val; // stores the NEW min value outside of stack
        }
        stack.push(val);
    }

    public void pop() {
        // if our popped value is equal to the current min, we pop again to store the new min outside of stack
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
