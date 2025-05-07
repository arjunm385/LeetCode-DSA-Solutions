class Solution {
    public int maxArea(int[] height) {
        
        int maxWater = 0;

        int l=0, r=height.length - 1;

        while(l<=r) {

            int max = 0;
            
            if(height[l] > height[r]) {
                max = height[r] * (r-l);
                r--;
            }

            else if(height[l] < height[r]) {
                max = height[l] * (r-l);
                l++;
            }

            else {
                max = height[l] * (r-l);
                r--;
                l++;
            }
            
            maxWater = Math.max(maxWater, max);
        }

        return maxWater;
        
    }
}