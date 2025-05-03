class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
        
        if(p.length() > s.length()) {
                return list;
            }

        Map<Character,Integer> map= new HashMap<>();

        int k=p.length();

        for(Character c: p.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for(int i=0;i<k;i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i)) - 1);
            }
        }

        if(check(map)) {
            list.add(0);
        }

        for(int i=k; i<s.length(); i++){
            
            char curr = s2.charAt(i);
            char prev = s2.charAt(i-k);
            
            if(map.containsKey(curr)) {
                map.put(curr, map.get(curr) - 1);
            }

            if(map.containsKey(prev)) {
                map.put(prev, map.get(prev) + 1);
            }

            if(check(map))
                list.add(i - k + 1);

        }

        return list;
        
    }

    public boolean check(Map<Character,Integer> map) {
        return map.values().stream().filter(v-> v>0).count()==0;
    }
}