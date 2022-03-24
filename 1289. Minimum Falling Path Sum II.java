class Solution {
    
    public int[][] arr = new int[205][205];
    
    public int dp(int[][] grid,int r,int c){
        int n = grid.length;
        int m = grid[0].length;
        if(r>=n || c>=m){
            return Integer.MAX_VALUE;
        }
        if(r==n-1){
            return arr[r][c]=grid[r][c];
        }
        if(arr[r][c]!=Integer.MIN_VALUE){
            return arr[r][c];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            if(i!=c){
                ans=Math.min(ans,dp(grid,r+1,i));
            }
        }
        return arr[r][c]=grid[r][c]+ans;
    }
    
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.MIN_VALUE;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            ans=Math.min(ans,dp(grid,0,i));
        }
        return ans;
    }
}