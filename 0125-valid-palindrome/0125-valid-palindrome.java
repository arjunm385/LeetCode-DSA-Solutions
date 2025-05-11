class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();

        s = s.toLowerCase();

        for(char c: s.toLowerCase().toCharArray()) {
            if(Character.isAlphabetic(c) || Character.isDigit(c)) {
                sb.append(c);
            }
        }

        int l=0, r= sb.length() - 1;

        while(l<r) {
            if(sb.charAt(l++) != sb.charAt(r--))
                return false;
        }

        return true;
        
    }
}