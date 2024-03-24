class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        findPermutations(nums, 0, nums.length - 1, list);

        return list;
        
    }

    static void findPermutations(int arr[], int l, int r, List<List<Integer>> list) {
        //Base Case:
        if(l == r) {
            addToList(arr, list);
            return;
        }

        for(int i=l; i<=r; i++) {
            swap(arr, i, l);
            findPermutations(arr, l+1, r, list);
            swap(arr, i, l);
        }
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void addToList(int arr[], List<List<Integer>> list) {
        List<Integer> l = new ArrayList<>();
        for(int a: arr) {
            l.add(a);
        }
        list.add(l);
    }
}