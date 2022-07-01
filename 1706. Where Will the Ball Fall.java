class Solution {
    
    public int explore(int r, int c, int[][] grid, int[][] visited){
        if(r==grid.length){
            return c;
        }
        if(r<0 || c<0 || c>=grid[0].length){
            return -1;
        }
        if(visited[r][c]!=0){
            return visited[r][c];
        }
        int ans = -1;
        if(grid[r][c]==1 && c+1<grid[0].length && grid[r][c+1]==1){
            ans=explore(r+1,c+1,grid,visited);
        } else if (grid[r][c]==-1 && c>0 && grid[r][c-1]==-1){
            ans=explore(r+1,c-1,grid,visited);
        }
        visited[r][c]=ans;
        return visited[r][c];
    }
    
    public int[] findBall(int[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        int[] ans = new int[grid[0].length];
        for(int i=0;i<grid[0].length;i++){
            ans[i]=explore(0,i,grid,vis);
        }
        return ans;
    }
}