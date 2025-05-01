class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=1, r=1;
        int n = nums.length;

        int[] prefix = new int[n+1];
        prefix[0] = 0;

        for(int i=0; i<n; i++) {
            prefix[i+1] = prefix[i] + nums[i];
        }

        System.out.println(Arrays.toString(prefix));

        

        int min = Integer.MAX_VALUE;

        while(r<n+1) {

            int sum = prefix[r] - prefix[l-1];

            if(prefix[r] - prefix[l-1] < target) {
                r++;
            }

            else {
                System.out.println(sum + ", pos: r:" + r + ", l:" + l);
                min = Math.min(min, r-l+1);
                l++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
        
    }
}