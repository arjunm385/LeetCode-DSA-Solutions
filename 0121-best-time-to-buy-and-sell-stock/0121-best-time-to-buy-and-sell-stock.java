class Solution {
    public int maxProfit(int[] prices) {

        //You can code here

        int min = Integer.MAX_VALUE, maxProfit = Integer.MIN_VALUE;

        for(int i: prices) {
            min = Math.min(min, i);
            maxProfit = Math.max(maxProfit, i - min);
        }

        return maxProfit;
        
    }
}