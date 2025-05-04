class Solution {
    public int totalFruit(int[] fruits) {

        Map<Integer, Integer> map = new HashMap<>();

        int l=0,r=0;
        int max = 0;

        while(r<fruits.length) {

            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            if(map.size()<=2) {
                max = Math.max(max, r-l+1);
                r++;
            }

            else {
                int count = map.size();

                while(count > 2) {
                    if(map.get(fruits[l]) < 2) {
                        map.remove(fruits[l]); 
                    }
                    else {
                        map.put(fruits[l], map.get(fruits[l]) - 1);
                    }
                    l++;
                    count = map.size();
                }
            }
        }

        return max;
    }
}