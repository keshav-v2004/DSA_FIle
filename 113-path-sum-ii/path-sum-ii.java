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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> answer = new ArrayList<>();
        if(root==null) return answer;



        List<Integer> eachPath = new ArrayList<>();

        helper(root , eachPath , targetSum , 0 , answer);
        return answer;

    }
    public void helper(
        TreeNode mover , 
        List<Integer> eachPath , int targetSum , int sumTillNow , List<List<Integer>> answer){

        if(mover.left==null && mover.right==null){

            if(sumTillNow + mover.val==targetSum){
                eachPath.add(mover.val);
                answer.add(new ArrayList<>(eachPath));
                eachPath.remove(eachPath.size()-1);
            }
            return;
        }
        
        sumTillNow+=mover.val;
        eachPath.add(mover.val);
        if(mover.left != null){
            helper(mover.left , eachPath , targetSum , sumTillNow , answer);
        }
        if(mover.right != null){
            helper(mover.right , eachPath , targetSum , sumTillNow , answer);
        }
        sumTillNow-=mover.val;
        eachPath.remove(eachPath.size()-1);

    }
}