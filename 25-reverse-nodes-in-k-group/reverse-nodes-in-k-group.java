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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prevGroupTail = null;

        while (temp != null) {

            ListNode node = getNode(temp, k);

            if (node == null) break;   // less than k nodes left

            ListNode groupNext = node.next;
            node.next = null;          // isolate the group

            ListNode newHead = reverseList(temp);

            if (prevGroupTail == null) {
                head = newHead;        // first group becomes new head
            } else {
                prevGroupTail.next = newHead;
            }

            prevGroupTail = temp;      // temp becomes tail after reverse
            temp = groupNext;          // move to next group
        }

        if (prevGroupTail != null) {
            prevGroupTail.next = temp; // attach remaining nodes
        }

        return head;
    }

    public ListNode reverseList(ListNode head) {

        if(head==null || head.next==null) return head;
        ListNode temp = null;

        ListNode mover = head;
        
        while(mover.next != null){

            ListNode next = mover.next;

            mover.next = temp;
            temp = mover;
            mover = next;
        }
        mover.next = temp;

        return mover;
    }

    public ListNode getNode(ListNode mover, int k) {
        while (mover != null && k > 1) {
            mover = mover.next;
            k--;
        }
        return mover;

    }
}