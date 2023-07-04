/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */
public class LC_21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Check if either list is null to see if we can return the other right away
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Set the initial head to the smallest value of the first node of list1 and list2
        ListNode head;
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        ListNode current = head; // Use a separate pointer for the current node so we can return the head later
        // Traverse the lists and keep comparing values while merging lists and updating pointers
        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) { // Compares values
                current.next = list1; // Updates output list
                list1 = list1.next; // Updates list's pointer
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next; // Updates current pointer
        }

        // When one list is null, attach remaining nodes from other list to the final list
        current.next = list1 == null ? list2 : list1;

        return head; // Returns the original head, now with a merged lists
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
