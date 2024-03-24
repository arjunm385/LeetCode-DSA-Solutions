class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();

        generate("", 0, 0, n, list);

        return list;
    }

    static void generate(String str, int o, int c, int n, List<String> list) {

        if(o == n && c == n) {
            list.add(str);
            return;
        }

        if(o < n) {
            //Backtracking by maintaining the state of str
            generate(str + '(', o + 1, c, n, list); 
        }

        if(c < o) {
            generate(str + ')', o, c + 1, n, list);
        }
    }
}