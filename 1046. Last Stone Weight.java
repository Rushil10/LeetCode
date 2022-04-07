class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        int n = stones.length;
        for(int i=0;i<n;i++){
            pq.add(stones[i]);
        }
        while(pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            if(a-b>0){
                pq.add(a-b);
            } 
        }
        if(pq.size()>0){
            return pq.peek();
        }
        return 0;
    }
}