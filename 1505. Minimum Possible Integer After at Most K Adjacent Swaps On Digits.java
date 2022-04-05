class Solution {
    public String minInteger(String num, int k) {
        int index = 0;
        int n = num.length();
        char[] arr = num.toCharArray();
        while(k!=0 && index<n){
            int rem = n-index;
            int min = Math.min(rem,k+1);
            char minValue = arr[index];
            int minIndex = index;
            for(int i=index+1;i<index+min;i++){
                if(arr[i]<minValue){
                    minValue=arr[i];
                    minIndex=i;
                }
            }
            if(minIndex==index){
                index++;
                continue;
            }
            int j = index+1;
            while(j<=minIndex){
                char c = arr[index];
                arr[index]=arr[j];
                arr[j]=c;
                j++;
            }
            k=k-(minIndex-index);
            index++;
        }
        return new String(arr);
    }
}