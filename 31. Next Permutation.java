class Solution {
    public void nextPermutation(int[] arr) {
        int k = -1;
        int N = arr.length;
        for(int i=N-1;i>=1;i--){
            if(arr[i-1]<arr[i]){
                k=i-1;
                break;
            }
        }
        if(k==-1){
            Arrays.sort(arr);
        } else {
            int num = arr[k];
            int min = arr[k+1];
            int sp = k+1;
            for(int i=N-1;i>k+1;i--){
                if(arr[i]<min && arr[i]>num){
                    sp=i;
                    min=arr[i];
                }
            }
            arr[k]=arr[sp];
            arr[sp]=num;
            Arrays.sort(arr,k+1,N);
        }
    }
}