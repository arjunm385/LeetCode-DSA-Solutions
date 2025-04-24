class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {

        int[] wordFreq = new int[words.length];
        int[] qFreq = new int[queries.length];

        for(int i=0; i<words.length; i++) {
            wordFreq[i] = getFreq(words[i]);
        }

        for(int i=0; i<queries.length; i++) {
            qFreq[i] = getFreq(queries[i]);
        }

        int[] res = new int[queries.length];

        for(int i=0; i<queries.length; i++) {
            int count = 0;
            for(int j: wordFreq) {
                if(qFreq[i] < j) {
                    count++;
                }
            }
            res[i] = count;
        }

        return res;
        
    }

    public int getFreq(String word) {

        char max = 'z';
        int freq = 0;
        
        for(char c: word.toCharArray()) {
            if(c == max) {
                freq++;
            }
            else if(c < max) {
                max = c;
                freq = 1;
            }
        }

        return freq;
    }
}