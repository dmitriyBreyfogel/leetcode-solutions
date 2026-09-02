package Easy;

import Common.ListNode;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        if (lengthA > lengthB) {
            int diff = lengthA - lengthB;
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        }
        else if (lengthB > lengthA) {
            int diff = lengthB - lengthA;
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
