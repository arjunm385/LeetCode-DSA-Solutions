class Solution {
    public int trap(int[] height) {

        int n = height.length;

        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            max = Math.max(max, height[i]);
            maxLeft[i] = max;
        }

        max = Integer.MIN_VALUE;

        for(int i=n-1; i>=0; i--) {
            max = Math.max(max, height[i]);
            maxRight[i] = max;
        }

        int sum = 0;

        for(int i=0; i<n; i++) {
            sum += Math.min(maxRight[i], maxLeft[i]) - height[i];
        }

        return sum;
        
        
    }
}   