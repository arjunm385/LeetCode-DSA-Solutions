class Solution {
    public void solveSudoku(char[][] board) {

        solveSudoku(board, 0, 0);
        
    }

    static boolean solveSudoku(char[][]  arr, int row, int col) {

        // Base condition:
        if(row == 9) {
            return true;
        }

        if(col == 9) {
            return solveSudoku(arr, row + 1, 0);
        }

        if(arr[row][col] != '.') {
            return solveSudoku(arr, row, col + 1);
        }

        for(int i = 1; i<=9; i++) {
            if(isValid(arr, row, col, i)) {
                arr[row][col] = (char) (i + '0');
                 if(solveSudoku(arr, row, col + 1))
                     return true;
                 else
                     arr[row][col] = '.';
            }
        }



        return false;
    }

    static boolean isValid(char[][] arr, int row, int col, int num) {

        for(int i = 0; i<9; i++) {
            if((arr[row][i] != '.' && arr[row][i] - '0' == num) ||
                    (arr[i][col] != '.' && arr[i][col] - '0' == num))
                return false;
        }

        int gridX = (row/3) * 3;
        int gridY = (col/3) * 3;

        for(int i = 0; i<3; i++) {
            for(int j = 0; j<3; j++) {
                if(arr[gridX + i][gridY + j] != '.' && arr[gridX + i][gridY + j] - '0' == num)
                    return false;
            }
        }

        return true;
    }
}