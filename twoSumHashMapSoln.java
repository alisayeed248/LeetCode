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

// 4/12/23
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // First implementation - check to see if target - nums[i] is in our map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // if target - nums[i] is in hashmap, return i and whatever is in hashmap
            if (map.containsKey(target - nums[i])) {
                // get returns the value the key is associated with, so make key the number and value the index
                return new int [] {map.get(target - nums[i]), i};
            }
            else {
                // key, value
                map.put(nums[i], i); // {(2, 0), }
            }
        }
        return new int [] { };
    }
}
