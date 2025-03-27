import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = Arrays.stream(nums).sum();

        List<Integer>[] leftSums = generateSubsetSums(Arrays.copyOfRange(nums, 0, n));
        List<Integer>[] rightSums = generateSubsetSums(Arrays.copyOfRange(nums, n, 2 * n));

        for (int i = 0; i <= n; i++) {
            Collections.sort(rightSums[i]);
        }

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            for (int leftSum : leftSums[i]) {
                int target = (totalSum / 2) - leftSum;
                int closestSum = findClosest(rightSums[n - i], target);
                int partitionSum = leftSum + closestSum;
                minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * partitionSum));
            }
        }

        return minDiff;
    }

    private List<Integer>[] generateSubsetSums(int[] arr) {
        int n = arr.length;
        List<Integer>[] subsetSums = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            subsetSums[i] = new ArrayList<>();
        }

        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0, count = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                    count++;
                }
            }
            subsetSums[count].add(sum);
        }
        return subsetSums;
    }

    private int findClosest(List<Integer> sortedSums, int target) {
        int index = Collections.binarySearch(sortedSums, target);
        if (index >= 0) return sortedSums.get(index);

        int insertPos = -index - 1;
        int best = Integer.MAX_VALUE;

        if (insertPos < sortedSums.size()) best = sortedSums.get(insertPos);
        if (insertPos > 0) best = Math.min(best, sortedSums.get(insertPos - 1));

        return best;
    }
}
