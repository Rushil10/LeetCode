class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int left=0;
        int right=n-1;
        int ans = 0;
        while(left<right){
            if(people[left]+people[right]<=limit){
                ans++;
                left++;
                right--;
            } else {
                ans++;
                right--;
            }
        }
        if(left==right){
            ans++;
        }
        return ans;
    }
}