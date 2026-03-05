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

    Set<Integer> set = new HashSet<>();

    public TreeNode convertBST(TreeNode root) {
        TreeNode mover = root;

        dfs(mover);

        mover = root;

        helper(mover);

        return root;
    }

    public void dfs(TreeNode mover){
        if(mover==null) return;

        set.add(mover.val);
        dfs(mover.left);
        dfs(mover.right);

    }

    public void helper(TreeNode mover){
        if(mover==null) return;

        int newVal = findSum(mover.val);
        mover.val = mover.val + newVal;

        helper(mover.left);
        helper(mover.right);
    }

    public int findSum(int val){
        int sum = 0;

        for(int elem : set){
            if(elem != val && elem > val){
                sum+=elem;
            }
        }
        return sum;
    }
}