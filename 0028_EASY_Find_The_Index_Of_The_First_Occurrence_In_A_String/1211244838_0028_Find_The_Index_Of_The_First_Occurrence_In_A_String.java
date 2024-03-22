class Solution {
    public int strStr(String haystack, String needle) {
        return occurrence(haystack, needle, 0);
    }

    static int occurrence(String str, String s, int i) {
        if(i > str.length() - s.length())
            return -1;
        
        if(s.equals(str.substring(i, i + s.length()))) 
            return i;
        
        return occurrence(str, s, i+1);
    }
}