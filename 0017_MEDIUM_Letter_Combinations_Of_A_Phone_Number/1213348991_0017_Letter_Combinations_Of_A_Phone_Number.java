class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<>();

        if(digits.isBlank()) {
            return list;
        }
        
        String[] arr = {
                "",
                "",
                "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        getWords(digits, arr, 0, "", list);

        return list;
        
    }

    static void getWords(String input, String[] arr, int index, String str, List<String> list) {
        // Base Condition
        if(index == input.length()) {
            list.add(str);
            return;
        }

        int pos = input.charAt(index) - '0';
        String current = arr[pos];

        for(int i=0; i < current.length(); i++) {
            getWords(input, arr, index+1, str + current.charAt(i), list);
        }
    }
}