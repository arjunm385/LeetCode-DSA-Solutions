class Solution {
    public int longestOnes(int[] nums, int k) {

        int l=0, r=0;
        int count = 0;
        int max = 0;

        while(r<nums.length) {
            if(nums[r] == 1) {
                count++;
                r++;
            }

            else if(nums[r] == 0 && k>0) {
                k--;
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