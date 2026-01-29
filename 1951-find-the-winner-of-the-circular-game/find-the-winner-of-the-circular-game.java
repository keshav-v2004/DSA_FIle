class Solution {
    public int findTheWinner(int n, int k) {
        
        ArrayList<Integer> all = new ArrayList<>();

        for(int i = 1 ; i<= n ; i++){
            all.add(i);

        }
        int startIndex = 0;

        while(all.size() > 1){
            int curLoserIndex = (startIndex + k-1) % all.size();
            all.remove(curLoserIndex);
            startIndex = (curLoserIndex ) % all.size();

        }
        return all.get(0);

    }
}