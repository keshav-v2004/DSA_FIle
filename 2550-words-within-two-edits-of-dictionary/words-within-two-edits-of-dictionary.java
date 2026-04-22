class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> answer = new ArrayList<>();

        for(String each : queries){

            boolean isPossible = false;
            for(String dict : dictionary){

                if(findDiff(each , dict) <= 2){
                    answer.add(each);
                    isPossible = true;
                }
                if(isPossible == true){
                    break;
                }
            }
        }
        return answer;
    }

    public int findDiff(String s1 , String s2){
        int count = 0;

        int n = s1.length();

        for(int i = 0 ; i < n ; i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if(ch1 != ch2){
                count++;
            }
        }
        return count;
    }
}