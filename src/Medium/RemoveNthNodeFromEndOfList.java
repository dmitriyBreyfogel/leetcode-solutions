package Medium;

import Common.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;

        int size = size(head);
        int shift = size - n;
        for (int i = 0; i < shift; i++) {
            prev = cur;
            cur = cur.next;
        }

        prev.next = cur.next;
        return dummy.next;
    }

    private int size(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
