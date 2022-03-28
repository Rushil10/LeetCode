class Solution {
    
    public boolean find(int[] nums,int target, int l, int h){
        if(l>h){
            return false;
        }
        int mid = (l+h)/2;
        if(nums[mid]==target){
            return true;
        }
        if(nums[l]==nums[mid] && nums[mid]==nums[h]){
            l++;
            h--;
            return find(nums,target,l,h);
        } else if(nums[l]<=nums[mid]){
            if(target>=nums[l] && target<=nums[mid]){
                return find(nums,target,l,mid-1);
            } else {
                return find(nums,target,mid+1,h);
            }
        } else if(target>=nums[mid] && target<=nums[h]){
            return find(nums,target,mid+1,h);
        }
        return find(nums,target,l,mid-1);
    }
    
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int h = n-1;
        return find(nums,target,l,h);
    }
}