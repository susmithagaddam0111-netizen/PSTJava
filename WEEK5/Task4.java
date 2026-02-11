class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;

        int maxEnding = nums[0];
        int maxSoFar = nums[0];

        int minEnding = nums[0];
        int minSoFar = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            totalSum += num;

            if (i > 0) {
                maxEnding = Math.max(num, maxEnding + num);
                maxSoFar = Math.max(maxSoFar, maxEnding);

                minEnding = Math.min(num, minEnding + num);
                minSoFar = Math.min(minSoFar, minEnding);
            }
        }
        if (maxSoFar < 0) {
            return maxSoFar;
        }

        return Math.max(maxSoFar, totalSum - minSoFar);
    }
}
