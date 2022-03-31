class Solution {
    
    public boolean countSubArrays(int[] nums,int max,int m){
        int sub = 0;
        int n = nums.length;
        int cur_sum = 0;
        for(int i=0;i<n;i++){
            if(nums[i]>max){
                return false;
            }
            cur_sum+=nums[i];
            if(cur_sum>max){
                sub++;
                cur_sum=nums[i];
            }
        }
        sub++;
        return sub<=m;
    }
    
    public int splitArray(int[] nums, int m) {
        int left = 0;
        int n = nums.length;
        int right = 0;
        for(int i=0;i<n;i++){
            right+=nums[i];
        }
        while(left<right){
            int mid = (left+right)/2;
            if(countSubArrays(nums,mid,m)){
                right=mid;
            } else {
                left=mid+1;
            }
        }
        return left;
    }
}