class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int[] a = new int[6];
        int[] b = new int[6];
        int[] ab = new int[6];
        
        for(int i=0;i<n;i++){
            a[tops[i]-1]++;
            b[bottoms[i]-1]++;
            if(tops[i]==bottoms[i]){
                ab[tops[i]-1]++;
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<6;i++){
            if(a[i]+b[i]-ab[i]>=n){
                int m = Math.min(a[i],b[i])-ab[i];
                if(m<min){
                    min=m;
                }
            }
        }
        
        if(min==Integer.MAX_VALUE){
            return -1;
        } 
        
        return min;
    }
}