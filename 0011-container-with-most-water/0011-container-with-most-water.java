class Solution {
    public int maxArea(int[] height) {
        int i=0, j=height.length-1;
        int max = Integer.MIN_VALUE;

        while(i<j) {
           if(height[i]<=height[j]) {
            max = Math.max(max,(j-i) * height[i]);
            i++;
           } 
           else {
            max = Math.max(max,(j-i) * height[j]);
            j--;
           }
        }
        return max;
    }
}