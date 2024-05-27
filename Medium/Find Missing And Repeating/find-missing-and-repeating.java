//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int a[], int n) {
        // code here

        int repeating = -1;
        int missing = -1;
        int pos = 1;
        
        Arrays.sort(a);

        for(int i = 0; i<a.length; i++) {

            if(repeating == -1 && i>0 && a[i] == a[i-1]) {
                repeating = a[i];
                continue;
            }
            if(missing == -1 && a[i] != pos) {
                missing = pos++;
            }
            pos++;
        }
        
        if(missing == -1)
            missing = n;

        int[] res = new int[2];
        res[0] = repeating;
        res[1] = missing;

        return res;
    }
}