// Soln 1: 

class Solution {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        maxLeft[0] = 0;
        for (int i = 1; i < height.length; i++) {
            if (maxLeft[i-1] < height[i-1]) maxLeft[i] = height[i-1];
            else maxLeft[i] = maxLeft[i-1];
        }
        int[] maxRight = new int[height.length];
        maxRight[height.length-1] = 0;
        for (int i = height.length-2; i >= 0; i--) {
            if (maxRight[i+1] < height[i+1]) maxRight[i] = height[i+1];
            else maxRight[i] = maxRight[i+1];
        }
        int[] minimum = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            minimum[i] = Math.min(maxLeft[i], maxRight[i]);
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int partial = minimum[i] - height[i];
            if (partial < 0) partial = 0;
            sum += partial;
        }
        return sum;
    }
}

// Soln 2

class Solution {
    public int trap(int[] height) {
        int maxLeft = height[0]; 
        int maxRight = height[height.length - 1];   

        int leftPointer = 0;
        int rightPointer = height.length - 1;

        int totalWater = 0;
        while (leftPointer < rightPointer) {
            if (maxLeft < maxRight) {
                leftPointer++;
                maxLeft = Math.max(maxLeft, height[leftPointer]);
                totalWater += maxLeft - height[leftPointer];
            }
            else {
                rightPointer--;
                maxRight = Math.max(maxRight, height[rightPointer]);
                totalWater += maxRight - height[rightPointer];
            }
        }
        return totalWater;
    }
}