package Easy;

import Common.ListNode;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            }
            else {
                prev = cur;
            }

            cur = cur.next;
        }

        return dummy.next;
    }
}
