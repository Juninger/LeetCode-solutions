import java.math.BigInteger;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */
public class LC_2_AddTwoNumbers {

    // solution that performs addition digit-by-digit
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(); // simplifies edge cases
        ListNode current = dummyHead; // pointer to current node in result list

        int carry = 0; // tracks carry number during addition

        // traverse lists and perform addition
        while (l1 != null || l2 != null || carry > 0) {

            // extracts values from current nodes
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int sum = val1 + val2 + carry; // sum of node values + carry
            carry = sum / 10; // extracts the first digit of the sum (if >9)
            sum = sum % 10; // extracts the last digit of the sum (if >9)
            current.next = new ListNode(sum); // adds sum to result list

            current = current.next; // move pointer in result list

            // move pointers in input lists
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummyHead.next;
    }

    // bad and slow solution : uses BigInteger and Strings to be able to convert and store huge numbers
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        // used to store representations of full numbers from linked lists
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        // traverse lists and build string with numbers
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                num1.insert(0, l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                num2.insert(0, l2.val);
                l2 = l2.next;
            }
        }

        // converts Strings to BigIntegers and adds them together
        // int and long too small for test cases, hence BigInteger
        BigInteger sum = new BigInteger(num1.toString()).add(new BigInteger(num2.toString()));

        // String representation of result
        String sumStr = sum.toString();

        // traverse result and build final LinkedList
        ListNode head = null;
        for (int i = 0; i < sumStr.length(); i++) {
            int number = Character.getNumericValue(sumStr.charAt(i));
            head = new ListNode(number, head);
        }
        return head;
    }

    // definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
