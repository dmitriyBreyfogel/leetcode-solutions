package Medium;

import Common.ListNode;

public class RotateList {
    // 0    1    2    3
    // 1 -> 2 -> 3 -> 4
    // k = 3    len = 4

    //    0    1    2    3
    // 1: 4 -> 1 -> 2 -> 3
    // 2: 3 -> 4 -> 1 -> 2
    // 3: 2 -> 3 -> 4 -> 1

    // k = k % len - keeps only effective shifts, skipping full cycles
    // len - k     - index in the original list of the node that becomes the new head
    // len - k - 1 - index in the original list of the node that becomes the new tail

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        // Count nodes; start at 1 so we count nodes, not edges
        int len = 1;
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
            len++;
        }

        k = k % len;
        if (k == 0) return head;

        // Walk to the node that will become the tail
        ListNode newLast = head;
        for (int i = 0; i < len - k - 1; i++) {
            newLast = newLast.next;
        }

        // Save the new head before breaking the link
        ListNode newHead = newLast.next;
        newLast.next = null;

        // Attach the old tail to the old head
        last.next = head;

        return newHead;
    }
}
