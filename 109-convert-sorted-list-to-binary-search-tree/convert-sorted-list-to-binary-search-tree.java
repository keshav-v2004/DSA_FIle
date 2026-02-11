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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;

        if(head.next ==null){
            return new TreeNode(head.val);
        }

        ArrayList<Integer> arr = new ArrayList<>();

        ListNode mover = head;

        while(mover != null){
            arr.add(mover.val);
            mover = mover.next;
        }

        Collections.sort(arr);

        int n = arr.size();

        return helper(0 , n-1 , arr);
    }

    public TreeNode helper(int l , int r , ArrayList<Integer> val){
        if(l > r) return null;

        int mid = l + (r-l)/2;

        TreeNode root = new TreeNode(val.get(mid));

        root.left = helper(l , mid-1 , val);
        root.right = helper(mid+1 , r , val);

        return root;
    }
}