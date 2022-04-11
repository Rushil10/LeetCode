class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] ab = new int[n][m];
        List<List<Integer>> ans = new ArrayList<>();
        k=k%(m*n);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int shifts = j+k;
                int ni = i;
                if(shifts>=m){
                    ni+=shifts/m;
                    shifts=shifts%m;
                    if(ni>=n){
                        ni=0+ni-n;
                    }
                }
                ab[ni][shifts]=grid[i][j];
            }
        }
        for(int i=0;i<n;i++){
            List<Integer> li = new ArrayList<>();
            for(int j=0;j<m;j++){
                li.add(ab[i][j]);
            }
            ans.add(li);
        }
        return ans;
    }
}