class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        String[] resultArray = new String[m];
        for(int i=m-1;i>=0;i--){
            int bit = Character.getNumericValue(num2.charAt(i));
            int carry = 0;
            StringBuilder res = new StringBuilder();
            int a = m-1;
            while(a>i){
                res.append("0");
                a--;
            }
            for(int j=n-1;j>=0;j--){
                int bit2 = Character.getNumericValue(num1.charAt(j));
                int mul = bit*bit2 + carry;
                res.append(String.valueOf(mul%10));
                carry = mul/10;
            }
            if(carry>0){
                res.append(String.valueOf(carry));
            }
            resultArray[m-i-1]=res.toString();
        }
        StringBuilder ans2 = new StringBuilder();
        for(int i=0;i<m;i++){
            StringBuilder ans = new StringBuilder(ans2);
            ans2.setLength(0);
            int a = ans.length();
            int b = resultArray[i].length();
            int tb = Math.max(a,b);
            int carry = 0;
            for(int j=0;j<tb;j++){
                int bit1 = 0;
                int bit2 = 0;
                if(j<a){
                    bit1=Character.getNumericValue(ans.charAt(j));
                }
                if(j<b){
                    bit2=Character.getNumericValue(resultArray[i].charAt(j));
                }
                int add = bit1+bit2+carry;
                int val = add%10;
                ans2.append(String.valueOf(add%10));
                carry = add/10;
            }
            if(carry>0){
                ans2.append("1");
            }
        }
        ans2.reverse();
        while(ans2.length()>0 && ans2.charAt(0)=='0'){
            ans2.deleteCharAt(0);
        }
        if(ans2.length()==0){
            return "0";
        }
        return ans2.toString();
    }
}