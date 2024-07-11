/**
 * Given the head of a linked list, remove the nth node from THE END of the list and return its head.
 */
public class LC_19_RemoveNthNodeFromEndOfList {

    /*
      solution idea: create two pointers with 'n' space between them, then keep shifting both forward
      until the right pointer reaches the end of the lift --> the node to remove will be at the left pointer
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode leftP = dummyHead;
        ListNode rightP = head;

        // shift right pointer to 'head + n' initially
        while (n > 0 && rightP != null) {
            rightP = rightP.next;
            n--;
        }

        // shift both pointers until the right one reaches the end of the list
        while (rightP != null) {
            leftP = leftP.next;
            rightP = rightP.next;
        }

        // "delete" the node by shifting the previous node's next-pointer by 1
        leftP.next = leftP.next.next;

        return dummyHead.next; // original head of the list
    }

     // definition for singly-linked list
     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
