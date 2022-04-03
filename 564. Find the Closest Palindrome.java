class Solution {
    
    public String nearestPalindrome(String s,boolean dir){
        int n = s.length();
        int k = n/2;
        String base = s.substring(0,n-k);
        int b = Integer.valueOf(base);
        b += dir ? 1 : -1;
        if(b==0){
            if(k==0){
                return "0";
            }
            return "9";
        }
        base = String.valueOf(b);
        StringBuilder left = new StringBuilder(base);
        StringBuilder right = new StringBuilder(left).reverse();
        if(k>left.length()){
            right.append("9");
        }
        return left.append(right.substring(right.length()-k)).toString();
    }
    
    public String nearestPalindromic(String s) {
        int n = s.length();
        char[] p = s.toCharArray();
        for(int i=0;i<n/2;i++){
            p[n-i-1]=p[i];
        }
        String curP = String.valueOf(p);
        String nextP = nearestPalindrome(curP,true);
        String prevP = nearestPalindrome(curP,false);
        
        long num = Long.valueOf(s);
        long next = Long.valueOf(nextP);
        long prev = Long.valueOf(prevP);
        long curr = Long.valueOf(curP);
        
        long d1 = Math.abs(num - curr);
        long d2 = Math.abs(num - prev);
        long d3 = Math.abs(num - next);
        
        if (num == curr) {
            return d2 <= d3 ? prevP : nextP;
        } else if (num > curr) {
            return d1 <= d3 ? curP : nextP;
        } else {
            return d2 <= d1 ? prevP : curP;
        }
    }
}