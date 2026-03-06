class Solution {
    public boolean checkOnesSegment(String s) {
        
        int segmentCount = 0;

        int segmentLen = 0 ;

        for(char ch : s.toCharArray()){
            if(ch=='1'){
                segmentLen++;
            }
            else{
                if(segmentLen > 0){
                    segmentCount++;
                    segmentLen = 0;
                }
                
            }
        }
        if(segmentLen > 0){
            segmentCount++;
        }
        return segmentCount <= 1;
    }
}