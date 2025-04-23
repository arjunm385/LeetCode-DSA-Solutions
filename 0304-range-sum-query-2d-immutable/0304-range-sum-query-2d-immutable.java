class NumMatrix {

    int[][] arr;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        arr = new int[n][m];

        for(int i=0; i<n; i++) {
            arr[i][0] = matrix[i][0];

            for(int j=1; j<m; j++) {
                arr[i][j] = arr[i][j-1] + matrix[i][j];
            }
        }

        for(int j=0; j<m; j++) {
            arr[0][j] = arr[0][j];

            for(int i=1; i<n; i++) {
                arr[i][j] = arr[i-1][j] + arr[i][j];
            }
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = arr[row2][col2];

        if(row1 > 0) {
            sum -= arr[row1 - 1][col2];
        }

        if(col1 > 0) {
            sum -= arr[row2][col1 - 1];
        }

        if(col1 > 0 && row1 > 0) {
            sum += arr[row1-1][col1-1];
        }

        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */