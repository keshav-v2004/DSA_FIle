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
    HashMap<Integer , Integer> map = new HashMap<>();
    int[] inorder;
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        this.inorder = inorder;

        int n = inorder.length;

        for(int i = 0 ; i < n ; i++){
            map.put(inorder[i] , i);
        }

        return helper(preorder , 0 , n-1);


    }

    public TreeNode helper(int[] preOrder , int start , int end){
        if(start > end) return null;

        int rootVal = preOrder[index];
        index++;

        int inOrderIndex = map.get(rootVal);

        TreeNode parent = new TreeNode(rootVal);
        
        parent.left = helper(preOrder , start , inOrderIndex-1);
        parent.right = helper(preOrder , inOrderIndex+1 , end);

        return parent;
    }
}