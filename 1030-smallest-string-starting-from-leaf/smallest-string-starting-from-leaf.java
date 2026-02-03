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

        String answer = "";

        public String smallestFromLeaf(TreeNode root) {
            
            if(root==null) return "";

            if(root.left == null && root.right ==null){
                return String.valueOf((char)(root.val + 'a'));
            }
            
            dfs(root , new StringBuilder());
            return answer;
        }

        public void dfs(TreeNode mover , StringBuilder string){
            if(mover.left==null && mover.right==null){
                char ch = (char)(mover.val + 'a');
                string.append(ch);

                String curr = new StringBuilder(string).reverse().toString();

                if(answer.isEmpty() || curr.compareTo(answer) < 0){
                    answer = new StringBuilder(curr).toString();

                }

                string.deleteCharAt(string.length() - 1);
                return;
            }

            char ch = (char)(mover.val + 'a');
            string.append(ch);
            
            if(mover.left != null){
                dfs(mover.left , string);
            }

            if(mover.right != null){
                dfs(mover.right , string);
            }

            string.deleteCharAt(string.length() - 1);
            
            
        }


    }