class Solution {
    public int minPartitions(String n) {
        int answer = 0;

        for(char ch : n.toCharArray()){
            answer = Math.max(answer , ch-'0');
        }
        return answer;
    }
}