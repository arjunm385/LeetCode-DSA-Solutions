class Solution {
    public List<List<String>> solveNQueens(int n) {

        boolean[][] arr = new boolean[n][n];

        List<List<String>> list = new ArrayList<>();

        placeQueens(arr, 0, 0, n, list);

        return list;
        
    }

    static void placeQueens(boolean[][] arr, int row, int queens, int n, List<List<String>> list) {
        // Base condition:
        if(queens == n) {
            list.add(addToList(arr));
            return;
        }
        if(row == n) {
            return;
        }

        for(int i=0; i<n; i++) {
            if(isValidPlace(arr, row, i, n)) {
                arr[row][i] = true;
                placeQueens(arr, row+1, queens + 1, n, list);
                arr[row][i] = false;
            }
        }

    }

    static boolean isValidPlace(boolean[][] arr, int row, int col, int n) {
        for(int i=0; i<n; i++) {
            if(arr[row][i] || arr[i][col])
                return false;

            if(row + i < n && col + i < n && arr[row+i][col+i])
                return false;

            if(row - i >=0 && col - i >= 0 && arr[row-i][col-i])
                return false;

            if(row + i < n  && col - i >= 0 && arr[row+i][col-i])
                return false;

            if(row - i >= 0 && col + i < n && arr[row-i][col+i])
                return false;
        }

        return true;
    }

    static List<String> addToList(boolean[][] arr) {

        List<String> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for(boolean[] a: arr) {
            for(boolean b: a) {
                if(b)
                    sb.append("Q");
                else
                    sb.append(".");
            }

            list.add(sb.toString());
            sb.delete(0, sb.length());
        }

        return list;
    }
}