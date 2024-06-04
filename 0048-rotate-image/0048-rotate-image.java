class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        for (int k = 0; k < n / 2; k++) {
            for (int i = k; i < n - 1 - k; i++) {

                int x = k, y = i;
                int temp = matrix[x][y];

                for (int j = 0; j < 4; j++) {

                    int val = matrix[y][n - x - 1];
                    matrix[y][n - x - 1] = temp;
                    temp = val;

                    int tx = x;
                    x = y;
                    y = n - tx - 1;
                }
            }
        }
        
    }
}