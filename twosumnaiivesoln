class Solution {
    public int[] twoSum(int[] nums, int target) { //returns an integer array, given the array of integers num and a target
        int [] answer = new int [2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return answer;
    }
}
