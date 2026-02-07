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
    int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        this.inorder = inorder;

        int n = inorder.length;
        index = n-1;

        for(int i = 0 ; i < n ; i++){
            map.put(inorder[i] , i);
        }

        return helper(postorder , 0 , n-1);


    }

    public TreeNode helper(int[] postorder , int start , int end){
        if(start > end) return null;

        int rootVal = postorder[index];
        index--;

        int inOrderIndex = map.get(rootVal);

        TreeNode parent = new TreeNode(rootVal);

        parent.right = helper(postorder , inOrderIndex+1 , end);
        parent.left = helper(postorder , start , inOrderIndex-1);
        

        return parent;
    }
}