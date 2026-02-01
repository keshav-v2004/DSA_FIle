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

    Map<Integer , Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        
        List<Integer> answer = new ArrayList<>();

        dfs(root);

        int max = Integer.MIN_VALUE;

        for(int val : map.values()){
            max = Math.max(max , val);
        }

        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            if(entry.getValue()==max){
                answer.add(entry.getKey());
            }
        }
        int[] output = new int[answer.size()];
        for(int i = 0 ; i < answer.size() ; i++){
            output[i] = answer.get(i);
        }
        return output;


    }

    public int dfs(TreeNode mover){
        if(mover==null){
            return 0;
        }

        int left = dfs(mover.left);
        int right = dfs(mover.right);

        int sum = mover.val + left + right;

        map.put(sum , map.getOrDefault(sum , 0)+1);
        return sum;
    }


}