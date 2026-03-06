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
        return mergeSort(head);

    }

    public ListNode mergeSort(ListNode head){
        if(head==null || head.next == null) return head;

        ListNode middle = findMiddle(head);
        ListNode rightHead = middle.next;
        middle.next = null;

        ListNode leftHead = mergeSort(head);
        rightHead = mergeSort(rightHead);

        ListNode finalHead = merge(leftHead , rightHead);
        
        return finalHead;
    }

    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode head1 , ListNode head2){

        ListNode ptr1 = head1;
        ListNode ptr2 = head2;

        ListNode head = null;

        if(ptr1.val < ptr2.val){
            head = new ListNode(ptr1.val);
            ptr1 = ptr1.next;

        }
        else{
            head = new ListNode(ptr2.val);
            ptr2 = ptr2.next;
        }
        ListNode mover = head;

        while(ptr1 != null && ptr2 != null){
            if(ptr1.val < ptr2.val){
                mover.next = ptr1;
                ptr1 = ptr1.next;
            }
            else{
                mover.next= ptr2;
                ptr2 = ptr2.next;
            }
            mover = mover.next;
        }

        while(ptr1 != null){
            mover.next = ptr1;
            mover = mover.next;
            ptr1 = ptr1.next;

        }
        
        while(ptr2 != null){
            mover.next = ptr2;
            mover = mover.next;
            ptr2 = ptr2.next;
            
        }

        return head;

    }
}