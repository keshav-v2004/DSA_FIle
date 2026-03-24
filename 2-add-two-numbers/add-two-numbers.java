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
                ListNode m1 = l1;
                ListNode m2 = l2;

                ListNode root = new ListNode();


                int carry = 0;
                int sum = m1.val + m2.val + carry;

                carry = sum / 10;
                sum = sum % 10;

                root.val = sum;

                m1 = m1.next;
                m2 = m2.next;

                ListNode m3 = root;

                while (m1 != null && m2 != null){

                        ListNode temp = new ListNode();

                        sum = m1.val + m2.val + carry;

                        carry = sum / 10;
                        sum = sum % 10;

                        temp.val = sum;


                        m3.next = temp;
                        m1 = m1.next;
                        m2 = m2.next;
                        m3 = temp;
                }

                while (m1 != null){

                        ListNode temp = new ListNode();
                        sum = m1.val + carry;

                        carry = sum / 10;
                        sum = sum % 10;


                        temp.val = sum;

                        m3.next = temp;
                        m3 = m3.next;

                        m1 = m1.next;


                }
                while (m2 != null){

                        ListNode temp = new ListNode();
                        sum = m2.val + carry;

                        carry = sum / 10;
                        sum = sum % 10;


                        temp.val = sum;

                        m3.next = temp;
                        m3 = m3.next;

                        m2 = m2.next;


                }


                if (carry != 0){
                        ListNode temp = new ListNode();
                        temp.val = 1;

                        m3.next = temp;
                }

                return root;
    }
}