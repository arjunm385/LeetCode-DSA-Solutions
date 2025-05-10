class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0; i<nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, i+1, -nums[i], i, list);
        }

        return list;
        
    }

    public void twoSum(int[] numbers, int start, int target, int p, List<List<Integer>> list) {

        int end=numbers.length - 1;
        int l = start;
        int r = end;

        while(l<r) {

            if(l>start && numbers[l] == numbers[l-1]) {
                l++;
                continue;
            }

            if(r<end && numbers[r] == numbers[r+1]) {
                r--;
                continue;
            }

            if(numbers[l] + numbers[r] < target)
                l++;

            else if(numbers[l] + numbers[r] > target)
                r--;

            else {
                List<Integer> triplets = new ArrayList<>();
                triplets.add(numbers[p]);
                triplets.add(numbers[l++]);
                triplets.add(numbers[r--]);
                list.add(triplets);
            }
        }
    }
}