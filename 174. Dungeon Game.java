class Solution {
    
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n][m];
        int i=0;
        int s = m+n;
        while(i<s-1){
            int k=0;
            int r = n-1;
            if(i>=m){
                r=s-i-2;
            }
            int c = m-1-i;
            if(c<0){
                c=0;
            }
            while(r>=0 && c<m){
                if(r==n-1 && c==m-1){
                    if(dungeon[r][c]<0){
                        dp[r][c]=-dungeon[r][c];
                    }
                } else {
                    if(r==n-1){
                        int rc = dp[r][c+1];
                        dp[r][c]=rc-dungeon[r][c];
                    } else if(c==m-1) {
                        int dc = dp[r+1][c];
                        dp[r][c]=dc-dungeon[r][c];
                    } else {
                        int min = Math.min(dp[r][c+1],dp[r+1][c]);
                        dp[r][c]=min-dungeon[r][c];
                    }
                    if(dp[r][c]<0){
                        dp[r][c]=0;
                    }
                }
                r--;
                c++;
            }
            i++;
        }
        return dp[0][0]+1;
    }
}