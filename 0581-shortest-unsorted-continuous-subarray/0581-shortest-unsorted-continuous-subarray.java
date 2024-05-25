class Solution {
    public int findUnsortedSubarray(int[] A) {

        int s = -1;
        int e = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i+1]) {
                s = i;
                break;
            }
        }

        for (int i = A.length - 1; i > 0; i--) {
            if (A[i] < A[i-1]) {
                e = i;
                break;
            }
        }

        if (s == -1 && e == -1) {
            return 0;
        }

        for (int i = s; i <= e; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }

        for (int i = 0; i <= s; i++) {
            if (A[i] > min) {
                s = i;
                break;
            }
        }

        for (int i = A.length - 1; i >= e; i--) {
            if (A[i] < max) {
                e = i;
            }
        }

        return e - s + 1;
        
    }
}