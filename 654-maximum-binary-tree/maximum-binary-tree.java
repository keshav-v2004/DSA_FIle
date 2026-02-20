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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        return helper(nums , 0 , nums.length - 1);

    }

    public TreeNode helper(int[] nums , int l , int r){
        if(l > r) return null;

        int[] pair = findMax(nums , l , r);

        if(pair[0]==-1) return null;
        
        int maxIndex = pair[1];
        int maxValue = pair[0];


        TreeNode root = new TreeNode(nums[maxIndex]);

        root.left = helper(nums , l , maxIndex-1);
        root.right = helper(nums , maxIndex+1 , r);

        return root;
    }

    public int[] findMax(int[] nums , int start , int end){
        
        int max = -1;
        int index = -1;

        for(int i = start ; i<= end ; i++){
            if(nums[i] > max){
                max = nums[i];
                index = i;

            }
        }

        return new int[]{max , index};
    }
}