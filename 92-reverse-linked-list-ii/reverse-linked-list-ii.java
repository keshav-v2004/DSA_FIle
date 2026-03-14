/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || left == right)
            return head;

        ListNode grpPrev = null;
        ListNode grpTail = null;

        ListNode mover = head;

        ListNode grpStart = null;
        ListNode grpEnd = null;

        if (left != 1) {

            while (left - 1 != 1) {
                mover = mover.next;
                left--;
                right--;
            }
            grpPrev = mover;
            grpStart = mover.next;

            while (right - 1 != 1) {
                mover = mover.next;
                right--;
            }
            grpEnd = mover.next;

            if (grpEnd.next != null) {
                grpTail = grpEnd.next;
            }

            grpPrev.next = null;
            grpEnd.next = null;

            ListNode newHead = reverse(grpStart);

            grpPrev.next = newHead;

            mover = newHead;
            while (mover.next != null) {
                mover = mover.next;

            }
            mover.next = grpTail;

            return head;
        }

        else{

            while(right - 1 != 1){
                mover = mover.next;
                right--;
            }

            grpStart = head;
            grpEnd = mover.next;

            if(grpEnd.next != null){
                grpTail = grpEnd.next;
            }

            grpEnd.next = null;

            ListNode newHead = reverse(grpStart);

            mover = newHead;

            while(mover.next != null){
                mover = mover.next;

            }

            mover.next = grpTail;

            head = newHead;
            return head;

            
        }

    }

    public ListNode reverse(ListNode grpHead) {

        ListNode mover = grpHead;

        ListNode prev = null;

        while (mover != null) {
            ListNode next = mover.next;

            mover.next = prev;
            prev = mover;
            mover = next;
        }

        return prev;

    }

}