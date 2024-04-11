class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            List<List<Integer>> list = new ArrayList<>();
            getPairs(nums, -nums[i], i + 1, nums.length - 1, list);
            if (!list.isEmpty()) {
                res.addAll(list);
            }
        }

        return res;
        
    }

    static void getPairs(int[] a, int t, int l, int r, List<List<Integer>> list) {

        int start = l;

        while (l < r) {

            if (l > start && a[l] == a[l - 1]) {
                l++;
                continue;
            }

            if (r < a.length - 1 && a[r] == a[r + 1]) {
                r--;
                continue;
            }

            if (a[l] + a[r] < t) {
                l++;
            } else if (a[l] + a[r] > t) {
                r--;
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(-t);
                temp.add(a[l]);
                temp.add(a[r]);
                list.add(temp);
                l++;
                r--;
            }
        }
    }
}