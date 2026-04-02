class Solution {

    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        helper(candidates , 0 , target ,new ArrayList<>());

        return answer;
    }

    public void helper(int[] arr , int index , int target , List<Integer> each){

        if(target < 0) return;
        
        if(target == 0){
            answer.add(new ArrayList<>(each));
            return;
        }

        if(index == arr.length){
            return;
        }

        // add this number again
        each.add(arr[index]);
        helper(arr,index , target - arr[index] , each);

        // backtrack
        each.remove(each.size()-1);
        
        // skip this number
        helper(arr,index+1 , target , each);



    }
}