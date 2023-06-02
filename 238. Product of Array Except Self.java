class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            // [1,2,3,4] [1,1,2,6]
            res[i] = prefix;
            // res[0] = 1; res[1] = 1; res[2] = 2; res[3] = 6;
            prefix *= nums[i];
            // prefix = 1; prefix = 2; prefix = 6; prefix = 24;
        }
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }
}
