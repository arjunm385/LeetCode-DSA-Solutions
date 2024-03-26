//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        
        Set<String> set = new TreeSet<>();

        permute(S.split(""), 0, "", set);
        
        return new ArrayList<String>(set);
    }
    
    static void permute(String[] input, int index, String res, Set<String> set) {

        if(index == input.length) {
            set.add(res);
            return;
        }

        for(int i = index; i<input.length; i++) {
             swap(input, i, index);
            permute(input, index+1, res + input[index], set);
            swap(input, i, index);
        }

    }

    static void swap(String[] str, int i, int j) {
        String temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}