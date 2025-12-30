class Solution {
    public int minDeletionSize(String[] strs) {
        
        int n = strs[0].length();

        ArrayList<String> cols = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            String col = "";
            for(String str : strs){
                col+=String.valueOf(str.charAt(i));
            }
            cols.add(col);
        }
        int count = 0;
        for(String eachCol : cols){
            for(int i = 0 ; i < eachCol.length()-1 ; i++){
                if(eachCol.charAt(i) > eachCol.charAt(i+1)){
                    count++;
                    break;
                }
            }
        }
        return count;

    }
}