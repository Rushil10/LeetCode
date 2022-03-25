class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            int a=i;
            int b=0;
            for(int j=i;j<n;j++){
                if(a==b){
                    dp[b][a]=1;
                } else if(a-b==1){
                    if(s.charAt(b)==s.charAt(a)){
                        dp[b][a]=2;
                    } else {
                        dp[b][a]=1;
                    }
                } else {
                    if(s.charAt(b)==s.charAt(a)){
                        dp[b][a]=Math.max(2+dp[b+1][a-1],Math.max(dp[b][a-1],dp[b+1][a]));
                    } else {
                        dp[b][a]=Math.max(dp[b][a-1],dp[b+1][a]);
                    }
                }
                a++;
                b++;
            }
        }
        return n-dp[0][n-1];
    }
}