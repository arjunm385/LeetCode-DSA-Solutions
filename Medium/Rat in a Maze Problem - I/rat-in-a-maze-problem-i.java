//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] mat, int n) {
        // Your code here
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        
        ArrayList<String> res = new ArrayList<>();
        
        if(mat[0][0] == 1){
            vis[0][0] = true;
            res = findPath(mat, vis, n, m, 0, 0, "", new ArrayList<>());
        }
        
        return res;
    }
        
    
    static boolean isValidPath(int[][] mat, boolean[][] vis, int n, int m, int i, int j) {
        return i<n && i>=0 && j>=0 && j<m && mat[i][j] == 1 && !vis[i][j];
    }

    // Directions D L R U
    static ArrayList<String> findPath(int[][] mat, boolean[][] vis, int n, int m, int i, int j, String path, ArrayList<String> res) {

        //Base case
        if(i == n-1 && j == m-1) {
            res.add(path);
        }

        // Case D:
        if(isValidPath(mat, vis, n, m, i+1, j)) {
            vis[i+1][j] = true;
            res = findPath(mat, vis, n, m, i+1, j, path + 'D', res);
            vis[i+1][j] = false;
        }

        // Case L:
        if(isValidPath(mat, vis, n, m, i, j-1)) {
            vis[i][j-1] = true;
            res = findPath(mat, vis, n, m, i, j-1, path + 'L', res);
            vis[i][j-1] = false;
        }

        // Case R:
        if(isValidPath(mat, vis, n, m, i, j+1)) {
            vis[i][j+1] = true;
            res = findPath(mat, vis, n, m, i, j+1, path + 'R', res);
            vis[i][j+1] = false;
        }

        // Case U:
        if(isValidPath(mat, vis, n, m, i-1, j)) {
            vis[i-1][j] = true;
            res = findPath(mat, vis, n, m, i-1, j, path + 'U', res);
            vis[i-1][j] = false;
        }

        return res;
    }
}