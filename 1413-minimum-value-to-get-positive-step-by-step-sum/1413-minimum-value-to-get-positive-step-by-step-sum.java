class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int count = 1;

        for(int i: nums) {
            sum += i;

            if(sum<=0) {
                count += -sum;
                sum=0;
            }
        }

        return count;
        
    }
}