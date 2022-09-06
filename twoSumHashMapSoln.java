class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] soln = new int[2];
        int valueSearch;
        HashMap<Integer, Integer> newMap = new HashMap <Integer, Integer>(); // form of value : index
        // iterate once through array: if target - nums[i] == val in hashmap, then get indices, if not, add to hashmap
        for (int i = 0; i < nums.length; i++) {
            // place values in hashmap
            valueSearch = target - nums[i]; // remember to put variable being assigned first
            // valueSearch = 7; 2;
            if (newMap.containsKey(valueSearch)) { // false, doesn't have 7
                // int testValue2 = newMap.get(i);
                soln[0] = i;
                // soln[0] = newMap.get(i); 
                // int testValue = newMap.get(valueSearch);
                // soln[1] = testValue;
                soln[1] = newMap.get(valueSearch);// --> gives null pointer exception
                return soln;
            }
            else {
                newMap.put(nums[i], i); // key: 2; value: 0;
            }
        } return soln;
    }
}
