class Solution {
    
    public boolean checkPalindrome(String s,int start,int end){
        int left = start;
        int right = end;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return checkPalindrome(s, start + 1, end) ||
                    checkPalindrome(s, start, end - 1);
            } 
            start++;
            end--;
        }
        return true;
    }
}