class Solution {
    
    public int checkOne(int[][] board,int i,int j){
        int n = board.length;
        int m = board[0].length;
        int l = 0;
        if(i-1>=0 && j-1>=0 && board[i-1][j-1]==1){
            l++;
        }
        if(i-1>=0  && board[i-1][j]==1){
            l++;
        }
        if(i-1>=0 && j+1<m && board[i-1][j+1]==1){
            l++;
        }
        if(j-1>=0 && board[i][j-1]==1){
            l++;
        }
        if(j+1<m && board[i][j+1]==1){
            l++;
        }
        if(i+1<n && j-1>=0 && board[i+1][j-1]==1){
            l++;
        }
        if(i+1<n  && board[i+1][j]==1){
            l++;
        }
        if(i+1<n && j+1<m && board[i+1][j+1]==1){
            l++;
        }
        return l;
    }
    
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] copy = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                copy[i][j]=board[i][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int o = checkOne(copy,i,j);
                if(board[i][j]==1){
                    if(o<2 || o>3){
                        board[i][j]=0;
                    }
                } else {
                    if(o==3){
                        board[i][j]=1;
                    }
                }
            }
        }
    }
}