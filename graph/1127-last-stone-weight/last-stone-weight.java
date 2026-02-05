class Solution {
    public int lastStoneWeight(int[] stones) {
        int n =stones.length;
        if(n==1){return stones[0];}
        PriorityQueue<Integer> heap =
        new PriorityQueue<>(Collections.reverseOrder());
        for(int x : stones){
            heap.add(x);
        }
        while(heap.size()!=1){
            int top1=heap.poll();
            int top2=heap.poll();
            int val=Math.abs(top1-top2);
            heap.add(val);
        }
        return heap.poll();
    }
}

