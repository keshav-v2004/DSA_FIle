class Solution {

    List<List<Integer>> answer;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        answer = new ArrayList<>();

        Arrays.sort(candidates);

        helper(candidates , target , 0 , new ArrayList<>());

        return answer;


    }

    public void helper(int[] arr , int target , int index , List<Integer> each){

        if(target == 0){
            answer.add(new ArrayList<>(each));

            return;
        }

        for(int i = index ; i < arr.length ; i++){

            if(i > index && arr[i] == arr[i-1]) continue;

            if(arr[i] > target) break;
            
            each.add(arr[i]);
            helper(arr, target - arr[i], i + 1, each);
            each.remove(each.size() - 1);

        }

    }


}