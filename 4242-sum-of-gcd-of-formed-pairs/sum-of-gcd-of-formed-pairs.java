class Solution {
    public long gcdSum(int[] nums) {
        
        int n = nums.length;

        int[] max = new int[n];

        max[0] = nums[0];

        for(int i = 1 ; i < n ; i++){
            max[i] = Math.max(max[i-1] , nums[i]);

        }

        int[] prefixGcd = new int[n];

        for(int i = 0 ; i < n ; i++){
            int a = nums[i];
            int b = max[i];

            if(a > b){
                prefixGcd[i] = findGcd(a,b);
            }
            else{
                prefixGcd[i] = findGcd(b,a);
            }
        }

        Arrays.sort(prefixGcd);

        int l = 0;
        int r = n-1;

        long sum = 0;


        while(l < r){

            int a = prefixGcd[l];
            int b = prefixGcd[r];

            sum += (long) findGcd(b,a);
            l++;
            r--;
        }

        return sum;


    }

    public int findGcd(int a , int b){

        while(a > 0 && b > 0){
            
            if(a > b){
                a = a % b;
            }
            else{
                int temp = b;
                b = a;
                a = temp;

                a = a % b;
            }
        }

        if(a==0) return b;
        return a;

    }
}