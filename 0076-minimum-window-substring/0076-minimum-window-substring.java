class Solution {
    public String minWindow(String s, String t) {

        if(t.length()>s.length())
            return "";

        int[] org = new int[256];
        int[] test = new int[256];

        for(char c: t.toCharArray()) {
            org[c]++;
        }

        for(char c: s.toCharArray()) {
            test[c]++;
        }

        if(!arrCheck(org, test)) {
            return "";
        }

        String res = s;
        test = new int[256];

        int l=0, r=0;

        while(r<s.length()) {

            while(!arrCheck(org, test) && r<s.length()) {
                test[s.charAt(r)]++;
                r++;
            }

            while(arrCheck(org, test)) {
                test[s.charAt(l)]--;
                l++;
            }

            if(res.length() > r-l+1)
                res = s.substring(l-1, r);

        }

        return res;

    }

    public boolean arrCheck(int[] org, int[] test) {
        for(int i=0; i<256; i++) {
            if(org[i]!=0 && test[i]<org[i]) {
                return false;
            }
        }
        return true;
    }
}