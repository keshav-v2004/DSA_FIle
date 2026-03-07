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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next == null) return head;

        ListNode grpPrev = null;

        ListNode mover = head;

        while(mover != null){

            ListNode node = mover.next;
            if(node==null){
                break;
            }

            ListNode grpNext = node.next;
            node.next =null;

            ListNode newNode = reverse(mover);

            if(grpPrev==null){
                head = newNode;
                grpPrev = mover;
                mover.next = grpNext;

                mover = mover.next;
            }
            else{
                grpPrev.next = newNode;
                grpPrev= mover;
                mover.next = grpNext;
                mover = mover.next; 
            }
        }
        return head;
    }
    public ListNode reverse(ListNode mover){

        ListNode newHead = mover.next;
        newHead.next = mover;
        mover.next = null;

        return newHead;
    }
}