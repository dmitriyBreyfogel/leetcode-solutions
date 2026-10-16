package Medium;

import Common.ListNode;

public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.next.val == cur.val) cur = cur.next;
                pre.next = cur.next;
            }
            else pre = cur;
            cur = cur.next;
        }

        return dummy.next;
    }
}
