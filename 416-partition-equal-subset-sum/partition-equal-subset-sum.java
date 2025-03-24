class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num : nums){
            sum=sum+num;
        }
        if(sum%2!=0) {return false;}
        else{
        return subsetSum(sum/2,nums);
        }
    }
    public static boolean subsetSum(int target ,int arr[]){
        int n =arr.length;
        boolean dp[][] = new boolean[n+1][target+1];
        for(int i =0;i<n+1;i++){
            dp[i][0]=true;
        }
        for(int j=1;j<target+1;j++){
            dp[0][j]=false;
        }




        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }                                                                                                                                                                                                                                       
        }
        return dp[n][target];
    }
}