class Solution {
    public String longestCommonPrefix(String[] arr) {

        int minLength = Integer.MAX_VALUE;
        String word = "";
        for(String i: arr) {
            if(i.length() < minLength) {
                minLength = i.length();
                word = i;
            }
        }

        minLength = Integer.MAX_VALUE;

        for(String curr: arr) {
            int count = 0;
            for(int i=0; i<word.length(); i++) {
                if(curr.charAt(i) != word.charAt(i)) {
                    break;
                }
                count++;
            }
            if(count == 0){
                return "";
            }
            minLength = Math.min(minLength, count);
        }

        return word.substring(0, minLength);
    }
}