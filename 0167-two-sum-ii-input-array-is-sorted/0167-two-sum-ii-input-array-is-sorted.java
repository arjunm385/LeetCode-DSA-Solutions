class Solution {

    int[] res = new int[2];

    public int[] twoSum(int[] numbers, int target) {

        int l=0, r=numbers.length - 1;

        while(l<r) {
            if(numbers[l] + numbers[r] < target)
                l++;

            else if(numbers[l] + numbers[r] > target)
                r--;

            else {
                res[0] = l+1;
                res[1] = r+1;
                return res;
            }
        }

        return new int[2];
        
    }
}