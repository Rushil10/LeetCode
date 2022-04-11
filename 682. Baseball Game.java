class Solution {
    public int calPoints(String[] ops) {
        List<Integer> li = new ArrayList<>();
        int n = ops.length;
        for(int i=0;i<n;i++){
            if(ops[i].equals("C")){
                li.remove(li.size()-1);
            } else if(ops[i].equals("D")){
                li.add(li.get(li.size()-1)*2);
            } else if(ops[i].equals("+")){
                int a = li.size();
                li.add(li.get(a-1)+li.get(a-2));
            } else {
                li.add(Integer.valueOf(ops[i]));
            }
        }
        int s = li.size();
        int ans = 0;
        for(int i=0;i<s;i++){
            ans+=li.get(i);
        }
        return ans;
    }
}