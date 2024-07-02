class Solution {
    public static void setZeroes(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        boolean rowZero = false;
        boolean colZero = false;

        //checking zero for row
        for(int i=0; i<m; i++) {
            if(matrix[0][i] == 0) {
                rowZero = true;
                break;
            }
        }

        //checking zero for column
        for(int i=0; i<n; i++) {
            if(matrix[i][0] == 0) {
                colZero = true;
                break;
            }
        }

        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        //making internal row zeros
        for(int i=1; i<n; i++) {
            if(matrix[i][0] == 0)
                makeRowZero(matrix, i, m);
        }

        //making internal column zeros
        for(int i=1; i<m; i++) {
            if(matrix[0][i] == 0)
                makeColZero(matrix, i, n);
        }

        if(rowZero) {
            matrix[0][0] = 0;
            makeRowZero(matrix, 0, m);
        }

        if(colZero) {
            matrix[0][0] = 0;
            makeColZero(matrix, 0, n);
        }

    }

    static void makeRowZero(int[][] matrix, int row, int m) {
        for(int i=1; i<m; i++) {
            matrix[row][i] = 0;
        }
    }

    static void makeColZero(int[][] matrix, int col, int n) {
        for(int i=1; i<n; i++) {
            matrix[i][col] = 0;
        }
    }
}