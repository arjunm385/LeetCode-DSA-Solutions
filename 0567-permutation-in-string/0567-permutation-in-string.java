class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) {
            return false;
        }

        Map<Character,Integer> map= new HashMap<>();

        int k=s1.length();

        for(Character c: s1.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(int i=0;i<k;i++){
            if(map.containsKey(s2.charAt(i))){
                map.put(s2.charAt(i),map.get(s2.charAt(i)) - 1);
            }
        }

        if(check(map)) {
            return true;
        }

        for(int i=k; i<s2.length();i++){

            char curr = s2.charAt(i);
            char prev = s2.charAt(i-k);
            
            if(map.containsKey(curr)) {
                map.put(curr, map.get(curr) - 1);
            }

            if(map.containsKey(prev)) {
                map.put(prev, map.get(prev) + 1);
            }

            if(check(map))
                return true;

        }

        return false;
        
    }

    public boolean check(Map<Character,Integer> map) {
        return map.values().stream().filter(v-> v>0).count()==0;
    }
}