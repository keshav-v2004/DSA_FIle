class Solution {
    public boolean checkStrings(String s1, String s2) {
        if(s1.equals(s2)) return true;

        Map<Character , Integer> evenMap1 = new HashMap<>();
        Map<Character , Integer> evenMap2 = new HashMap<>();
        
        Map<Character , Integer> oddMap1 = new HashMap<>();
        Map<Character , Integer> oddMap2 = new HashMap<>();
        
        int n = s1.length();

        for(int i = 0 ; i < n ; i++){

            
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(i);

            if(i % 2 == 0){
                evenMap1.put(ch1 , evenMap1.getOrDefault(ch1 , 0)+1);
                evenMap2.put(ch2 , evenMap2.getOrDefault(ch2 , 0)+1);
            }

            else{
                oddMap1.put(ch1 , oddMap1.getOrDefault(ch1 , 0)+1);
                oddMap2.put(ch2 , oddMap2.getOrDefault(ch2 , 0)+1);
            }
        }
        if(oddMap1.equals(oddMap2)  && evenMap1.equals(evenMap2)) return true;

        return false;

    }
}