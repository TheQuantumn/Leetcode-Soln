class Solution {
    public int findClosestNumber(int[] nums) {
        int closest = nums[0];  // Initialize with the first element of the array
        
        for (int num : nums) {
            // If the current number is closer to zero or same distance but positive
            if (Math.abs(num) < Math.abs(closest) || 
               (Math.abs(num) == Math.abs(closest) && num > closest)) {
                closest = num;
            }
        }
        
        return closest;
    }
}
