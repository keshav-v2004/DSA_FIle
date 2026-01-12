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

class Solution{
    public ListNode deleteDuplicates(ListNode head) {
    if(head == null || head.next == null) return head;

    HashMap<Integer , Integer> map = new HashMap<>();
    ListNode mover = head;

    while(mover != null){
        map.put(mover.val , map.getOrDefault(mover.val , 0) + 1);
        mover = mover.next;
    }

    ListNode newHead = null;
    mover = head;

    while(mover != null){
        if(map.get(mover.val) == 1){
            newHead = mover;
            mover = mover.next;
            break;
        }
        mover = mover.next;
    }

    if (newHead == null) return null; 

    ListNode newMover = newHead;

    while(mover != null){
        if(map.get(mover.val) == 1){
            newMover.next = mover;
            newMover = newMover.next;
        }
        mover = mover.next;
    }

    newMover.next = null; 
    return newHead;
}

}
