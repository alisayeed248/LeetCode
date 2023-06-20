class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!numSet.contains(nums[i])) numSet.add(nums[i]);
        }
        // 100, 4, 200, 1, 3, 2
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!numSet.contains(nums[i] - 1)) { // if numSet.contains(99)
                count++; // count = 1
                int j = i; // j = 0 
                int val = 1;
                while (numSet.contains(nums[j] + val)) { // while numSet.contains(nums[0] + 1)
                    count++;  
                    val++;
                }
            }
            if (count > maxCount) maxCount = count;
            count = 0;
        }
        return maxCount;
    }
}
