class Solution {
    public int subarraySum(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();


        int sum = 0;
        int compliment = 0;
        int count = 0;

        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            compliment = sum - k;

            if(map.containsKey(compliment)){
                count += map.get(compliment);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }

        

        return count;
        
    }
}

//