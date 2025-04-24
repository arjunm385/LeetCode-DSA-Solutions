class Solution {
    public int removeDuplicates(int[] nums) {

        int count = 0;
        int lastPrinted = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++) {
            if(lastPrinted != nums[i]) {
                lastPrinted = nums[i];
                count=1;
            }
            else if(lastPrinted == nums[i] && count == 1) {
                count++;
            }
            else{
                nums[i] = Integer.MIN_VALUE;
            }
        }

        int p=0;
        count = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] != Integer.MIN_VALUE) {
                swap(nums, i, p++);
                count++;
            }
        }

        return count;
        
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}