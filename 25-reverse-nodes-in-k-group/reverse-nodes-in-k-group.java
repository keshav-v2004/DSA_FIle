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
        ListNode grpPrev = null;

        while(temp != null){


            ListNode node = getNode(temp , k);

            // means less than k nodes available --> should remain as it is
            if(node == null) break;
            
            ListNode grpNext = node.next;

            node.next = null;

            ListNode newNode = reverse(temp);

            // for the first group
            if(grpPrev == null){
                head = newNode;

                grpPrev = temp;
                temp.next = grpNext;
                temp = temp.next;
            }

            // not the first group
            else{
                grpPrev.next = newNode;
                grpPrev = temp;
                temp.next = grpNext;

                temp = temp.next;
            }
        }
        return head;

    }

    public ListNode reverse(ListNode head){

        ListNode mover = head;

        ListNode prev = null;

        while(mover != null){
            ListNode next = mover.next;
            mover.next = prev;
            prev = mover;
            mover = next;
        }

        // return the new head
        return prev;

    }
    public ListNode getNode(ListNode mover , int k){

        while(mover != null && k > 1){
            mover = mover.next;
            k--;
        }
        return mover;
    }
}