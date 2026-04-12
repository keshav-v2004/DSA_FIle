class Solution {
    public int mirrorFrequency(String s) {

        int[] letterHash = new int[26];
        int[] digitHash = new int[10];

        for(char ch : s.toCharArray()){

            // if letter
            if(ch >= 'a' && ch <= 'z'){
                int val = ch - 'a';
                letterHash[val]++;
            }

            // else it is digit
            else{
                int val = ch - '0';
                digitHash[val]++;
            }
        }

        int totalSum = 0;

        // for letters

        int low = 0;
        int high = 25;

        while(low < high){

            totalSum += Math.abs(letterHash[low] - letterHash[high]);
            low++;
            high--;
        }

        low = 0;
        high = 9;

        while(low < high){
            totalSum += Math.abs(digitHash[low] - digitHash[high]);
            low++;
            high--;
        }

        return totalSum;

    }
}