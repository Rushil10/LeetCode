class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        int[] vis = new int[26];
        
        for(int i=0;i<n;i++){
            cnt[s.charAt(i)-'a']++;
        }
        
        String res = "";
        
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            cnt[c-'a']--;
            
            if(vis[s.charAt(i)-'a']==0){
                int size = res.length();
                while(size>0 && res.charAt(size-1)>c && cnt[res.charAt(size-1)-'a']>0){
                    vis[res.charAt(size-1)-'a']=0;
                    res=res.substring(0,size-1);
                    size--;
                }
                res+=c;
                vis[c-'a']++;
            }
        }
        
        return res;
    }
}