class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        long ans = 0;
        for(int i=0;i<n-2;i++){
            int left = i+1;
            int right = n-1;
            int t = target-arr[i];
            while(left<right){
                if(arr[left]+arr[right]>t){
                    right--;
                } else if(arr[left]+arr[right]<t){
                    left++;
                } else if(arr[left]!=arr[right]){
                    int l=1;
                    while(arr[left]==arr[left+1]){
                        left++;
                        l++;
                    }
                    left++;
                    int r = 1;
                    while(arr[right]==arr[right-1]){
                        right--;
                        r++;
                    }
                    right--;
                    ans=(ans+(l*r))%1000000007;
                } else {
                    int num = right-left+1;
                    int add = (num*(num-1))/2;
                    ans=(ans+add)%1000000007;
                    break;
                }
            }
        }
        return (int)ans;
    }
}