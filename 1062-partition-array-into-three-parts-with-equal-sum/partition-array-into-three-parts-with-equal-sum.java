class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        boolean answer = false;

        int i = 0;
        int j = -1;
        int k = -1;

        int totalSum = 0;
        for(int elem : arr){
            totalSum+=elem;
        }   
        if(totalSum%3!= 0) return false;

        int reqdSum = totalSum/3;
        int n = arr.length;
        int sum = 0;
        while(i < n){
            if(reqdSum==sum+arr[i]){
                j = i+1;
                break;
            }
            sum+=arr[i];
            i++;
        }
        if(j==-1) return false;
        sum = 0;
        while(j < n){
            if(reqdSum==sum + arr[j]){
                k = j+1;
                break;
            }
            sum+=arr[j];
            j++;
        }
        if(k==-1) return false;
        sum=0;
        while(k < n){
            if(reqdSum==sum + arr[k]){
                break;
            }
            sum+=arr[k];
            k++;
        }
        if(i<n && j < n && k < n) return true;
        return false;

    }
}