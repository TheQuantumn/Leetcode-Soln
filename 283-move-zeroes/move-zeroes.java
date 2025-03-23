class Solution {
    public void moveZeroes(int[] nums) {
      int n = nums.length;
      int start=0;
      for(int i =0 ; i<n; i++){
        if(nums[i]!=0){
            nums[start++]=nums[i];
        }
      }
      for(int i =start; i<n ; i++){
        nums[i]=0;
      }
    }
}