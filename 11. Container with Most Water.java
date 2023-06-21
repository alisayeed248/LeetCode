class Solution {
    public int maxArea(int[] height) {
        // [1, 8, 6, 2, 5, 3, 8, 3, 7]
        int leftPointer = 0, rightPointer = height.length - 1;
        int maxVal = 0; 
        int curVal;
        while (leftPointer < rightPointer) {
            curVal = (rightPointer - leftPointer) * (Math.min(height[leftPointer], height[rightPointer]));
            if (curVal > maxVal) {
                maxVal = curVal;
            }
            if (height[leftPointer] < height[rightPointer]) leftPointer++;
            else rightPointer--;
        }
        return maxVal;
    }
}
