class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int[] ans = new int[k];
        int index=0; 
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(index>=k){
                    break;
                }
                if(mat[j][i]==0){
                    if(i>0 && mat[j][i-1]==1){
                        ans[index]=j;
                        li.add(j);
                        index++;
                    } else if(i==0) {
                        ans[index]=j;
                        li.add(j);
                        index++;
                    }
                }
            }
        }
        if(index<k){
            for(int i=0;i<n;i++){
                if(!li.contains(i)){
                    li.add(i);
                    ans[index]=i;
                    index++;
                }
                if(index>=k){
                    break;
                }
            }
        }
        return ans;
    }
}