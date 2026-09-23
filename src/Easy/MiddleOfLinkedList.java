package Easy;

import Common.ListNode;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;

        int size = size(head);

        int index = size / 2;

        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    private int size(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
