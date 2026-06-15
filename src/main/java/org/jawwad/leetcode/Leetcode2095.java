package org.jawwad.leetcode;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class Leetcode2095 {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next;
            if (fast == null){
                break;
            }
            fast = fast.next;
        }

        ListNode current = head;
        while (current!=null){
            if (current.next == slow){
                current.next = current.next.next;

            }

            current = current.next;

        }

        // return slow;

        return head;
    }
}
