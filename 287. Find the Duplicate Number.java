class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int k = Math.abs(nums[i])-1;
            if(nums[k]<0){
                return k+1;
            } else {
                nums[k]=-nums[k];
            }
        }
        return 0;
    }
}