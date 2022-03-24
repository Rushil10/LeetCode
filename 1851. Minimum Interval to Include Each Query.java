class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,Comparator.comparingInt((int[] arr) -> arr[0]));
        int n = queries.length;
        int m = intervals.length;
        int[] q = queries.clone();
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[n];
        Arrays.sort(q);
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(n,(a,b) -> a.getKey()-b.getKey());
        int index = 0;
        for(int i=0;i<n;i++){
            int query = q[i];
            while(index<m && intervals[index][0]<=query){
                pq.add(new Pair(intervals[index][1]-intervals[index][0]+1,intervals[index][1]));
                index++;
            }
            while(!pq.isEmpty() && pq.peek().getValue()<query){
                pq.remove();
            }
            if(!pq.isEmpty()){
                map.put(query,pq.peek().getKey());
            } else {
                map.put(query,-1);
            }
        }
        for(int i=0;i<n;i++){
            ans[i]=map.get(queries[i]);
        }
        return ans;
    }
}