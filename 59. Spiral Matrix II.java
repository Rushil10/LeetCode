class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int st = 1;
        int r=0;
        int lr = n;
        int c=0;
        int lc = n;
        while(r<lr && c<lc){
            for(int i=c;i<lc;i++){
                ans[r][i]=st;
                st++;
            }
            r++;
            for(int j=r;j<lr;j++){
                ans[j][lc-1]=st;
                st++;
            }
            lc--;
            for(int i=lc-1;i>=c;i--){
                ans[lr-1][i]=st;
                st++;
            }
            lr--;
            for(int j=lr-1;j>=r;j--){
                ans[j][c]=st;
                st++;
            }
            c++;
        }
        return ans;
    }
}