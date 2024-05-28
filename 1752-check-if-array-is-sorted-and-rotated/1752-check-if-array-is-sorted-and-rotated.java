class Solution {
    public boolean check(int[] nums) {

        if(nums.length <= 1) {
            return true;
        }

        int[] arr = new int[2 * nums.length];
        for(int i=0; i<nums.length; i++) {
            arr[i] = nums[i];
            arr[i + nums.length] = nums[i];
        }

        int n = 0;

        for(int i=0; i<arr.length-1; i++) {

            if(arr[i]<=arr[i+1]) {
                n++;
            }
            else {
                n=0;
            }

            if(n == nums.length - 1)
                return true;
        }

        return false;
        
    }
}