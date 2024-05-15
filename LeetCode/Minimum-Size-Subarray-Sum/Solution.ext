class Solution {
    public int minSubArrayLen(int target, int[] a) {

        int l = 0, r = 0, minLen = Integer.MAX_VALUE, sum = a[r], n = a.length;

        while (r < n) {

            if (sum >= target) {
                minLen = Math.min(minLen, r - l + 1);
                sum -= a[l];
                l++;
            } else {
                r++;
                if (r < n)
                    sum += a[r];
            }
        }

        if(minLen == Integer.MAX_VALUE)
            minLen = 0;

        return minLen;
        
    }
}