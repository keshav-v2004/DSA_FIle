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
    public void reorderList(ListNode head) {
        ArrayDeque<ListNode> adq = new ArrayDeque<>();

        ListNode mover = head;
        while(mover != null){
            adq.offer(mover);
            mover = mover.next;

        }

        boolean fromFront = false;
        head = adq.pollFirst();
        mover = head;
        
        while(!adq.isEmpty()){
            if(fromFront==true){
                mover.next = adq.pollFirst();
            }
            else{
                mover.next = adq.pollLast();
            }
            fromFront = !fromFront;
            mover = mover.next;
        }

        mover.next= null;
        
        return ;
    }
}