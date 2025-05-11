class Solution {
    public boolean validPalindrome(String s) {

        if(isValid(s)) {
            return true;
        }

        int l=0, r=s.length() - 1;

        while(l<r) {
            if(s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
                continue;
            }
            else {
                return isValid(s.substring(l,r)) || isValid(s.substring(l+1, r+1));
            }
        }

        return true;
        
    }

    public boolean isValid(String s) {
        int l=0, r=s.length() - 1;

        while(l<r) {
            if(s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}