class Solution {
    public int maxSubArray(int[] nums) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for(int i: nums) {
            cs += i;
            ms = Math.max(ms, cs);
            if(cs<0)
                cs = 0;
        }

        return ms;
    }
}