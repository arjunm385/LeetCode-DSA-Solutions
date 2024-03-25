class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        getPermutations(nums, 0, nums.length - 1, list);

        Set<List<Integer>> set = new TreeSet<>(new sortList());

        list.forEach(set::add);

        return set.stream().collect(Collectors.toList());
    }

    static void getPermutations(int[] arr, int l, int r, List<List<Integer>> list) {

        if(l == r) {
            addToList(arr, list);
            return;
        }

        for(int i = l; i<=r; i++) {
            if(arr[i] != arr [l] || i == l) {
                swap(arr, l, i);
                getPermutations(arr, l+1, r, list);
                swap(arr, l, i);
            }
        }

    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void addToList(int[] arr, List<List<Integer>> result) {
        List<Integer> list = new ArrayList<>();
        for(int a: arr) {
            list.add(a);
        }

        result.add(list);

    }

}

class sortList implements Comparator<List<Integer>> {

    @Override
    public int compare(List<Integer> l1, List<Integer> l2) {
        for(int i=0; i<l1.size(); i++) {
            if(l1.get(i) != l2.get(i)) {
                return l1.get(i) - l2.get(i);
            }
        }

        return 0;
    }
}