class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pop = 0;
        Stack<Integer> st = new Stack<>();
        int i=0;
        int n = pushed.length;
        while(i<n){
            if(!st.isEmpty() && st.peek()==popped[pop]){
                while(!st.isEmpty() && st.peek()==popped[pop]){
                    st.pop();
                    pop++;
                }
            } else {
                st.push(pushed[i]);
                i++;
            }
        }
        while(!st.isEmpty() && st.peek()==popped[pop]){
            st.pop();
            pop++;
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}