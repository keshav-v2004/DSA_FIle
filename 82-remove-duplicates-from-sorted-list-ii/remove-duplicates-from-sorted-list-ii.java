class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode mover = head;
        ListNode newHead = null;
        ListNode newMover = null;

        while (mover != null) {

            if (mover.next != null && mover.val == mover.next.val) {
                int val = mover.val;
                while (mover != null && mover.val == val) {
                    mover = mover.next;
                }
            } 
            else {

                if (newHead == null) {
                    newHead = mover;
                    newMover = mover;
                } else {
                    newMover.next = mover;
                    newMover = newMover.next;
                }

                mover = mover.next;
                newMover.next = null; 
            }
        }

        return newHead;
    }
}
