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

    // bad and slow solution : uses BigInteger to be able to convert and store huge numbers
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

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

        BigInteger sum = new BigInteger(num1.toString()).add(new BigInteger(num2.toString()));
        String sumStr = sum.toString();

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
