class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        int cellsRemaining = n*n;
        int takenWeight = 0;
        int answer = 0;

        while(cellsRemaining > 0 && takenWeight < maxWeight){
            answer++;
            takenWeight+=w;
            cellsRemaining--;
        }
        if(takenWeight > maxWeight) return answer-1;
        return answer;
    }
}