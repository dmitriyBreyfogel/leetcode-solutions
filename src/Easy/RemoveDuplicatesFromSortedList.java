package Easy;

import Common.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy.next;

        while (pre.next != null) {
            if (pre.val == pre.next.val) {
                pre.next = pre.next.next;
            }
            else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
