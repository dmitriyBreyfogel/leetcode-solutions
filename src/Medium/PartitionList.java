package Medium;

import Common.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode lessDummy = new ListNode(0);
        ListNode moreDummy = new ListNode(0);
        ListNode lessTail = lessDummy;
        ListNode moreTail = moreDummy;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                lessTail.next = cur;
                lessTail = cur;
            } else {
                moreTail.next = cur;
                moreTail = cur;
            }
            cur = cur.next;
        }

        lessTail.next = moreDummy.next;
        moreTail.next = null;

        return lessDummy.next;
    }
}
