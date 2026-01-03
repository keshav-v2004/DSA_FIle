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
    public ListNode partition(ListNode head, int x) {
        if (head==null || head.next == null) return head;

        Queue<ListNode> q1 = new LinkedList<>();
        Queue<ListNode> q2 = new LinkedList<>();

        ListNode mover = head;
        while(mover != null){
            if(mover.val < x){
                q1.offer(mover);
                mover = mover.next;
            }
            else{
                q2.offer(mover);
                mover = mover.next;
            }
        }
        if(q1.isEmpty()){
            head = q2.poll();
        }
        else{
            head = q1.poll();
        }
        mover = head;
        while(!q1.isEmpty()){
            mover.next = q1.poll();
            mover = mover.next;
        }
        while(!q2.isEmpty()){
            mover.next = q2.poll();
            mover = mover.next;
        }
        mover.next = null;
        return head;
    }
}