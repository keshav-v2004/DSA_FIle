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
    public ListNode sortList(ListNode head) {

        if(head==null || head.next == null) return head;
        return helper(head);
    }

    public ListNode helper(ListNode mover){
        if(mover.next ==null){
            return mover;
        }

        ListNode newHead = helper(mover.next);
        ListNode prev = null;
        ListNode ptr = newHead;

        while(ptr != null && mover.val >= ptr.val ){
            prev = ptr;
            ptr = ptr.next;
        }

        if(prev==null){
            mover.next = newHead;
            newHead = mover;
        }
        else{
            prev.next = mover;
            prev = prev.next;
            prev.next = ptr;
        }
        return newHead;
    }
}