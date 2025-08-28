public class MaximumNumberOfOne {
  public int maxOnes(int arr[], int k) {
       int maxLength=0,countZero=0;
       int i=0,j;
       for(j=0;j<arr.length;j++){
           if(arr[j]==0) countZero++;
           while(countZero>k){
               if(arr[i++]==0) countZero--;
           }
           maxLength=Math.max(maxLength,j-i+1);
       }
        return maxLength;
    }
}
