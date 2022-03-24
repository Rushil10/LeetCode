class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        List<Character> li = new ArrayList<>();
        int n = s.length();
        int[] arr = new int[26];
        int last = -1;
        
        for(int i=0;i<n;i++){
            arr[s.charAt(i)-'a']++;
        }
        
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(!li.contains(c)){
                li.add(c);
            }
            arr[c-'a']--;
            int m = li.size();
            for(int j=0;j<m;j++){
                if(arr[li.get(j)-'a']==0){
                    li.remove(j);
                    j--;
                    m--;
                }
            }
            if(li.size()==0){
                ans.add(i-last);
                last=i;
            }
        }
        
        return ans;
    }
}