class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int exp = 0;
        Set<Integer> possiblePowersOfX = new HashSet<>();
        Set<Integer> possiblePowersOfY = new HashSet<>();

        while(true){
            if(x==1) {
                possiblePowersOfX.add(1);
                break;
            }
            int pow = (int) Math.pow(x,exp);
            if(pow <= bound){
                possiblePowersOfX.add(pow);
                exp++;
            } 
            else{
                break;
            }
        }
        exp = 0;
        while(true){
            if(y==1) {
                possiblePowersOfY.add(1);
                break;
            }
            int pow = (int) Math.pow(y,exp);
            if(pow <= bound){
                possiblePowersOfY.add(pow);
                exp++;
            } 
            else{
                break;
            }
        }

        Set<Integer> answer = new HashSet<>();
        for(int a : possiblePowersOfX){
            for(int b : possiblePowersOfY){
                if(a+b <= bound){
                    answer.add(a+b);
                }
            }
        }
        return new ArrayList<>(answer);
    }
}