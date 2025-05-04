class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int l=0, r=0;
        int max=Integer.MIN_VALUE;

        while(r<nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            if(map.get(nums[r])<=k) {
                max = Math.max(max, r-l+1);
                r++;
            }

            else {
                while(map.get(nums[r])>k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                l++;
                }
                map.put(nums[r], map.get(nums[r]) - 1);
            }
        }

        return max;
        
    }
}