// Solution 1: Two pointers method.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        Arrays.sort(nums); 
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        while (rightPointer > leftPointer) {
            if (nums[leftPointer] + nums[rightPointer] == target) {
                if (map.get(nums[leftPointer]).size() == 1){
                    return new int[] {map.get(nums[leftPointer]).remove(0), map.get(nums[rightPointer]).remove(0)};
                }
                else if (map.get(nums[leftPointer]).size() > 1) {
                    return new int[] {map.get(nums[leftPointer]).remove(0), map.get(nums[leftPointer]).remove(0)};
                }
            }
            else if (nums[leftPointer] + nums[rightPointer] > target) {
                rightPointer--;
            }
            else if (nums[leftPointer]+ nums[rightPointer] < target) {
                leftPointer++;
            }
        }
        return new int[] {};
    }
}

// Solution 2: Two for loops. O(n^2) time complexity, no added space complexity

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

// Solution 3: Hashmap solution, one pass. O(n) time complexity, O(n) space complexity

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int [] {map.get(target - nums[i]), i};
            }
            else {
                map.put(nums[i], i); 
            }
        }
        return new int [] { };
    }
}
