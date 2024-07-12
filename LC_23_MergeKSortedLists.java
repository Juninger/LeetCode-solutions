import java.util.PriorityQueue;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Example:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 */
public class LC_23_MergeKSortedLists {

    // solution using a min-heap
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null; // empty list edge case

        // min-heap with custom comparator to store ListNodes in order
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // add head of each list to minHeap
        for (ListNode head : lists) {
            if (head != null) minHeap.add(head);
        }

        ListNode dummyHead = new ListNode(-1); // helper variable to store head of return list
        ListNode curr = dummyHead; // pointer to the current while building return list

        // keep merging until heap is empty
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll(); // fetch the smallest item from heap
            curr.next = smallest; // add the smallest node to return list
            curr = curr.next; // move pointer to next node in return list

            // if the extracted node was not the last one, add the rest of the list back to the heap
            if (smallest.next != null) minHeap.add(smallest.next);
        }
        return dummyHead.next; // new merged list
    }

    /* -------------------------------------------------------------------------------------------- */

    /*
        solution idea: repeatedly merge PAIRS of lists to reach O(n*log(k))
    */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null; // empty list edge case
        int merges = lists.length; // tracks the number of total merges needed

        // keep merging until a single list remains
        while (merges > 1) {
            int newMerges = 0; // tracks the number of merged lists this iteration

            for (int i = 0; i < merges; i += 2) {
                // if we can, merge lists in pairs, otherwise carry the odd single list to next iteration
                lists[newMerges] = (i + 1) < merges ? mergeTwoLists(lists[i], lists[i + 1]) : lists[i];
                newMerges++; // +1 to merged lists
            }
            merges = newMerges; // number of lists that are ready for next iteration
        }
        return lists[0]; // updated with all lists merged
    }

    // helper function to merge two lists --> from LC_21_MergeTwoSortedLists
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

    // definition for singly-linked list
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
