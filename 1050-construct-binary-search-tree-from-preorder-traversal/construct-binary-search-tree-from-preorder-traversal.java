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
    public int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {

        // Preorder --> root left right
        // inorder -->  left root right

        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);

        int n = inorder.length;

        return helper(0, n - 1, inorder, preorder);

    }

    public TreeNode helper(int l, int r, int[] inorder, int[] preorder) {
        if (l > r)
            return null;

        int rootVal = preorder[index++];
        int rootIndex = findRootIndex(inorder, rootVal);

        TreeNode root = new TreeNode(rootVal);
        root.left = helper(l, rootIndex - 1, inorder, preorder);
        root.right = helper(rootIndex + 1, r, inorder, preorder);

        return root;

    }

    public int findRootIndex(int[] inorder, int rootVal) {
        int index = 0;

        for (int elem : inorder) {
            if (elem == rootVal) {
                return index;
            }
            index++;
        }
        return -1;
    }
}