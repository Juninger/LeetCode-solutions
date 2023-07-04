import java.util.*;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * E.g.
 * Input: head = [1,2,3,4,5]
 * Output:       [5,4,3,2,1]
 */
public class LC_206_ReverseLinkedList {

    /**
     * The general idea is to maintain two pointers to reverse the links:
     * 1. The current node
     * 2. The previous node
     * E.g. [1 -> 2 -> 3 -> 4 -> 5] with reversed links is [1 <- 2 <- 3 <- 4 <- 5]
     * @param head original head of the list
     * @return new head of the list
     */
    public ListNode reverseList(ListNode head) {

        ListNode current = head;
        ListNode previous = null; // original head does not have a previous linked node

        // We iterate and move pointers until current reaches null --> outside end of the list
        // At that point, the "previous" pointer contains the new head --> last node of the list
        while (current != null) {
            ListNode next = current.next; // Temporarily saves the next node
            current.next = previous; // Reverses the pointer (on first node this will be null)

            // Shifts both pointers one step "forward" towards end of list (new head)
            previous = current;
            current = next;
        }

        return previous;
        
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
