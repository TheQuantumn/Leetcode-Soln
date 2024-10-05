class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        Set<Integer> sums = new HashSet<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                sums.add(sum);
                if (sum < target) l++;
                else r--;
            }
        }
        
        int minDiff = Integer.MAX_VALUE, result = 0;
        for (int sum : sums) {
            int diff = Math.abs(sum - target);
            if (diff < minDiff) {
                minDiff = diff;
                result = sum;
            }
        }
        
        return result;
    }
}