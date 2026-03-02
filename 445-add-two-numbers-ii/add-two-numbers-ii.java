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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        ListNode m1 = l1;
        ListNode m2 = l2;

        while(m1 != null){
            s1.push(m1.val);
            m1 = m1.next;
        }
        
        while(m2 != null){
            s2.push(m2.val);
            m2 = m2.next;
        }

        int carry = 0;
        ListNode next = null;
        ListNode head = null;

        while(!s1.isEmpty() && !s2.isEmpty()){
            int d1 = s1.pop();
            int d2 = s2.pop();

            int totalSum = d1+d2+carry;
            int digitInserted = totalSum % 10;
            carry = totalSum / 10;

            head = new ListNode(digitInserted);
            head.next = next;
            next = head;
        }
        while(!s1.isEmpty()){
            int digit = s1.pop();
            int totalSum = digit + carry;

            int valInserted = totalSum % 10;
            carry = totalSum / 10;

            head = new ListNode(valInserted);
            head.next = next;
            next = head;

        }
        while(!s2.isEmpty()){
            int digit = s2.pop();
            int totalSum = digit + carry;

            int valInserted = totalSum % 10;
            carry = totalSum / 10;

            head = new ListNode(valInserted);
            head.next = next;
            next = head;
        }

        if(carry != 0){
            head = new ListNode(1);
            head.next = next;
        }
        return head;
    }
}