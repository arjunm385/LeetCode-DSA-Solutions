class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        int r = n - k%n;
        int[] t = new int[2*n];

        for(int i=0; i<n; i++) {
            t[i] = nums[i];
            t[i+n] = nums[i];
        }

        rotateArray(nums, t, r);
        
    }

    static void rotateArray(int[] a, int[] t, int k) {
        for(int i = 0; i<a.length; i++) {
            a[i] = t[i+k];
        }
    }
}