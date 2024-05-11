import java.util.HashSet;
import java.util.Set;

public class LC_141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        Set<ListNode> seen = new HashSet<>();

        while (head.next != null) {
            if(seen.contains(head)) {
                return true;
            }
            seen.add(head);
            head = head.next;
        }
        return false;
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


