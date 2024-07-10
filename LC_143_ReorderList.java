/**
 * You are given the head of a singly linked-list. The list can be represented as:
 * L0 → L1 → … → Ln - 1 → Ln
 *
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 *
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */
public class LC_143_ReorderList {

    /*
        solution: split list in half and traverse towards the middle from the beginning of first half and
        from the end of the second half. Second list must first be reversed for links to be correct when merging.
    */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return; // empty list

        // find middle of the list to know where to split it in half
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half of the list
        ListNode previous = null;
        ListNode current = slow.next; // new head of second half of linked list
        slow.next = null; // breaks the link between the two halves, ends first list at 'slow'-pointer
        while (current != null) {
            ListNode temp = current.next; // temporarily store next node
            current.next = previous; // swap pointers to reverse links
            previous = current; // move previous pointer forward
            current = temp; // move pointer to next node to handle
        }

        // merge the two halves of the list
        ListNode first = head; // original head, start of first half
        ListNode second = previous; // head of the reversed second half
        while (second != null) { // keep merging until all nodes have been processed
            ListNode firstNext = first.next; // next node of first half
            ListNode secondNext = second.next; // next node of second half
            first.next = second; // merge node from second half
            second.next = firstNext; // merge node from first half
            first = firstNext; // shift pointer to next node in first list
            second = secondNext; // shift pointer to next node in second list
        }
    }

    // definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
