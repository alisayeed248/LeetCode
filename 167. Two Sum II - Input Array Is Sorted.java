class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // O(1) space 
        // take the first two values --> if less, move the one on the right by one
        // --> if more, 
        int j = numbers.length - 1;
        int i = 0;
        while (numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] > target) j--;
            else if (numbers[i] + numbers[j] < target) i++;
        }
        return new int [] {i + 1, j + 1};
    }
}
