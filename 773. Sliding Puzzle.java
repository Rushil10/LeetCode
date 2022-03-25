class Solution {
    
    public int slidingPuzzle(int[][] board) {
        String start="";
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                start+=board[i][j];
            }
        }
        Queue<String> q = new LinkedList<>();
        q.add(start);
        String target = "123450";
        List<String> li = new ArrayList<>();
        int[][] dirs = new int[][] { { 1, 3 }, { 0, 2, 4 },
                { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
        int level = 0;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0;i<n;i++){
                String s = q.poll();
                if(li.contains(s)){
                    continue;
                }
                li.add(s);
                if(s.equals(target)){
                    return level;
                }
                int index = s.indexOf("0");
                for(int dir: dirs[index]){
                    String r = swap(s,index,dir);
                    q.add(r);
                }
            }
            level++;
        }
        return -1;
    }
    
    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}