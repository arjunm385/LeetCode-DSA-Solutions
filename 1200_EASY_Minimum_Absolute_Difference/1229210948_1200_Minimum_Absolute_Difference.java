class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        return getMinDiffPairs(arr);
        
    }

    static List<List<Integer>> getMinDiffPairs(int[] arr) {

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length-1; i++) {
            min = Math.min(min, arr[i+1] - arr[i]);
        }

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i+1] - arr[i] == min) {
                List<Integer> l = new ArrayList<>();
                l.add(arr[i]);
                l.add(arr[i+1]);
                list.add(l);
            }
        }

        return list;
    }
}