/* Three solutions:
1. Brute force using two for-loops to iterate through each pair combination to see if there's duplicates: O(n^2) time complexity, O(1) space complexity.
2. Sort the array first and then iterate through the sorted array, and if value at index i is equal to the value at index i + 1, duplicate. O(n log n) time complexity, 
O(1) space complexity.
3. Use a hashmap. Iterate through array, if you hit a value for the first time, add it to the map. If you hit it for a second time, return true. O(n) time, O(n) space.
*/

// Solution 1:
class Solution {
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) { // 0 to 5
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
// Issue: Time Limit Exceeded. Too slow for large data sets.


// Solution 2:
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
}
// Runtime: 21 ms, Memory: 57.5 MB.

// Solution 3:
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }
            else {
                return true;
            }
        }
        return false;
    }
}
// Runtime: 12 ms, Memory: 55.2 MB.
