import java.util.HashSet;
import java.util.Set;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class LC_141_LinkedListCycle {

    // "Floyd's Tortoise and Hare" || "two-pointer technique" - solution
    public boolean hasCycle(ListNode head) {
        ListNode slow = head; // "tortoise"
        ListNode fast = head; // "hare"

        while (fast != null && fast.next != null) {
            slow = slow.next; // tortoise moves one step
            fast = fast.next.next; // hare moves two steps

            if (slow == fast) { // hare "caught up" to tortoise by lapping --> has cycle
                return true;
            }
        }
        return false; // end of list reached --> no cycle
    }

    // HashSet solution
    public boolean hasCycle2(ListNode head) {

        // empty list
        if (head == null) {
            return false;
        }

        // visited nodes
        Set<ListNode> seen = new HashSet<>();

        // traverse linked list until last node
        while (head.next != null) {
            if(seen.contains(head)) { // same node found twice --> has cycle
                return true;
            }
            seen.add(head);
            head = head.next; // next node
        }
        return false; // end of list reached --> no cycle
    }

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}


