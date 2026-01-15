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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode begin = null;
        ListNode end = null;

        int count = k;

        ListNode mover = head;
        while(mover != null && count > 1){
            mover = mover.next;
            count--;
        }
        begin = mover;

        mover = head;
        int n = 0;
        while(mover != null){
            mover = mover.next;
            n++;
        }
        mover = head;
        int newCount = n-k+1;

        while(mover != null && newCount >1){
            mover = mover.next;
            newCount--;
        }
        end = mover;
        int temp = end.val;
        end.val = begin.val;
        begin.val = temp;

        return head;

    }
}