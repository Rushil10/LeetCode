class Solution {
    public int scoreOfParentheses(String s) {
        Stack<String> st = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c=='('){
                st.push("(");
            } else {
                if(st.peek()=="("){
                    st.pop();
                    st.push("1");
                } else {
                    int count = 0;
                    while(st.peek()!="("){
                        count=count+Integer.parseInt(st.peek());
                        st.pop();
                    }
                    st.pop();
                    st.push(String.valueOf(2*count));
                }
            }
        }
        int ans = 0;
        while(!st.isEmpty()){
            ans=ans+Integer.parseInt(st.peek());
            st.pop();
        }
        return ans;
    }
}