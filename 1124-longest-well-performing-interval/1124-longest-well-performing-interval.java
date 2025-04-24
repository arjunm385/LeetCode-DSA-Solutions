class Solution {
    public int longestWPI(int[] hours) {

        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        int sum = 0;

        for(int i=0; i<hours.length; i++) {
            if(hours[i]>8) {
                hours[i]=1;
            }
            else{
                hours[i]=-1;
            }
        }

        for(int i=0; i<hours.length; i++) {

            sum += hours[i];

            if(hours[i] == 1) {
                max = Math.max(max, 1);
            }

            if(sum>0) {
                max = Math.max(max, i+1);
            }

            else if(map.containsKey(sum-1)) {
                max = Math.max(max, i - map.get(sum-1));
            }

            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return max;
    }
}