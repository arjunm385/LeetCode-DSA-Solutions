class Solution {
    public int countSubarrays(int[] nums) {

        // [1,2,1,4,1]
        // [1,3,4,8,9]

        // [0,-4,-4]

        int count = 0;

        for(int i=0; i<nums.length-2; i++) {
            if(nums[i+1] % 2 != 0) {
                continue;
            }
            else if(nums[i] + nums[i+2] == nums[i+1] / 2) {
                count++;
            }
        }

        return count;
        
    }
}