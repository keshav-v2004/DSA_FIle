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

    ArrayList<String> all = new ArrayList<>();

    public int sumRootToLeaf(TreeNode root) {
        dfs(root ,new StringBuilder());

        int answer = 0;
        for(String s : all){
            answer+=parse(s);
        }
        return answer;
    }

    public int parse(String s){
        int sum = 0;
        int base = 1;

        for(int i = s.length()-1 ; i>= 0 ; i--){
            char ch = s.charAt(i);
            if(ch=='1'){
                sum+= base;
            }
            base = base *2;
        }
        return sum;
    }

    public void dfs(TreeNode mover , StringBuilder answer){
        if(mover.left==null && mover.right==null){
            answer.append(mover.val);
            all.add(answer.toString());
            answer.deleteCharAt(answer.length()-1);
            return;
        }

        answer.append(mover.val);
        if(mover.left != null){
            dfs(mover.left , answer);
        }
        if(mover.right != null){
            dfs(mover.right , answer);
        }
        answer.deleteCharAt(answer.length()-1);
    }
}