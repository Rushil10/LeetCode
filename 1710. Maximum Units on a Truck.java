class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b) -> b[1]-a[1]);
        int n = boxTypes.length;
        int ans = 0;
        int i=0;
        while(truckSize>0 && i<n){
            if(boxTypes[i][0]>truckSize){
                ans+=truckSize*boxTypes[i][1];
                truckSize=0;
            } else {
                ans+=boxTypes[i][0]*boxTypes[i][1];
                truckSize-=boxTypes[i][0];
            }
            i++;
        }
        return ans;
    }
}