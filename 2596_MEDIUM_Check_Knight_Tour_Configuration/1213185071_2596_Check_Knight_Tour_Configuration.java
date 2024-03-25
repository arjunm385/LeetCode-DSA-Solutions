class Solution {
    public boolean checkValidGrid(int[][] grid) {
        
        int n = grid.length;;

        return getTour(n, grid);
    }

    static boolean getTour(int n, int[][] grid) {
        int[] moveX = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] moveY = {1, 2, 2, 1, -1, -2, -2, -1};

        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = -1;
            }
        }

        arr[0][0] = 0;

        return getKnigthsPath(arr, moveX, moveY, 0, 0, 1, n, grid);
    }

    static boolean getKnigthsPath(int[][] arr, int[] moveX, int[] moveY, int posX, int posY, int step, int n, int[][] grid) {
        // Base Condition
        if(step == n * n) {
            return true;
        }

         for(int i=0; i<moveX.length; i++) {
             int x = posX + moveX[i];
             int y = posY + moveY[i];

             if(isValidMove(arr, x, y, n) && grid[x][y] == step) {
                 arr[x][y] = step;

                 if(getKnigthsPath(arr, moveX, moveY, x, y, step+1, n, grid)) {
                     return true;
                 }
                 else {
                     arr[x][y] = -1;
                 }
             }
         }

         return false;
    }

    static boolean isValidMove(int[][] arr, int x, int y, int n) {
        return x>=0 && y>=0 && x<n && y<n && arr[x][y] == -1;
    }
}