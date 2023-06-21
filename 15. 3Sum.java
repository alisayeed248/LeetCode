class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        // [-4, -1, -1, 0, 1, 2]
        for (int i = 0; i < nums.length-2; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            int leftPointer = i+1;
            int rightPointer = nums.length - 1;
            while (leftPointer < rightPointer) {
                int sum = nums[leftPointer] + nums[rightPointer] + nums[i];
                if (sum < 0) {
                    leftPointer++;
                }
                else if (sum > 0) {
                    rightPointer--;
                }
                else {
                    List<Integer> uniqueSoln = new ArrayList<>();
                    uniqueSoln.add(nums[i]);
                    uniqueSoln.add(nums[leftPointer]);
                    uniqueSoln.add(nums[rightPointer]);
                    res.add(uniqueSoln);
                    leftPointer += 1;
                    while (nums[leftPointer] == nums[leftPointer-1] && leftPointer < rightPointer) {
                        leftPointer += 1;
                    }
                }
            }

        }
        return res;
    }
}
