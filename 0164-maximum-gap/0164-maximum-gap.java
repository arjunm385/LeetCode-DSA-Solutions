class Solution {
    public int maximumGap(int[] arr) {

        if(arr.length < 2) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i: arr) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        double d = ((max - min) * 1.0) / (arr.length - 1);

        if(d<1.0)
            d = 1.0;

        int[] minBucket = new int[arr.length];
        int[] maxBucket = new int[arr.length];

        for(int i=0; i<arr.length; i++) {
            minBucket[i] = Integer.MAX_VALUE;
            maxBucket[i] = Integer.MIN_VALUE;
        }

        for (int i : arr) {
            int pos = (int) ((i - min) / d);
            minBucket[pos] = Math.min(minBucket[pos], i);
            maxBucket[pos] = Math.max(maxBucket[pos], i);
        }

        int prevMax = maxBucket[0];
        int maxGap = Integer.MIN_VALUE;

        for(int i=1; i<arr.length; i++) {
            if(minBucket[i] != Integer.MAX_VALUE) {
                maxGap = Math.max(maxGap, (minBucket[i] - prevMax));
                prevMax = maxBucket[i];
            }
        }

        return maxGap;
    }
}