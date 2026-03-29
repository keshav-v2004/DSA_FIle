class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;

        StringBuilder str = new StringBuilder(s1);

        for(int i = 0 ; i <= 1 ; i++){
            
            char ch1 = str.charAt(i);
            char ch2 = s2.charAt(i);

            if(ch1==ch2) continue;

            else{

                char ch3 = str.charAt(i+2);
                if(ch3 != ch2){
                    return false;
                }
                else{
                    str.setCharAt(i , ch3);
                    str.setCharAt(i+2 , ch1);
                }
            }
        }

        for(int i = 2 ; i <= 3 ; i++){
            char ch1 = str.charAt(i);
            char ch2 = s2.charAt(i);

            if(ch1 != ch2) return false;
        }
        return true;

    }
}