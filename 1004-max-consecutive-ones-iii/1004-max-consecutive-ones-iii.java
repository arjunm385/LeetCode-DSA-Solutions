class Solution {
    public int longestOnes(int[] nums, int k) {

        int l=0, r=0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        int flip = 0;

        int last = 0;

        while(r<nums.length) {
            if(nums[r] == 1) {
                count++;
                r++;
            }

            else if(nums[r] == 0 && flip<k) {
                flip++;
                count++;
                r++;
            }

            else {
                if(nums[l] == 0) {
                    l++;
                    r++;
                }
                else{
                    l++;
                    count--;
                }
            }

            max = Math.max(max, count);
        }
        
        return max;
    }
}