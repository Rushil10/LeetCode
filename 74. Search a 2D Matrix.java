class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=0;
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++){
            if(target>matrix[i][n-1]){
                r=r+1;
            } else {
                break;
            }
        }
        if(r>=m){
            return false;
        }
        for(int i=0;i<n;i++){
            if(matrix[r][i]==target){
                return true;
            }
        }
        return false;
    }
}