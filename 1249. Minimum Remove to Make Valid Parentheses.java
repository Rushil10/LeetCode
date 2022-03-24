class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        List<Integer> li = new ArrayList<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c==')'){
                if(st.isEmpty()){
                    li.add(i);
                } else {
                    st.pop();
                }
            } else if(c=='('){
                st.push(i);
            }
        }
        while(!st.isEmpty()){
            li.add(st.peek());
            st.pop();
        }
        Collections.sort(li);
        int d = li.size();
        StringBuilder t = new StringBuilder(s);
        for(int i=0;i<d;i++){
            t.deleteCharAt(li.get(i)-i);
        }
        return t.toString();
    }
}