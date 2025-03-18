class Solution {
    public int longestNiceSubarray(int[] nums) {
        if(nums.length==1) return 1;
        int max=1,k=0,val;
        int i=0,j=0;
        int[] setBit=new int[32];
        while(j<nums.length){
            k=0; 
            if(isNice(nums[j],setBit)){
                val=nums[j];
                while(val>0) {
                    setBit[k++]+=val&1;
                    val=val>>1;
                }
                j++;
            }
            else{
                  max=Math.max(max,j-i);
                  val=nums[i];
                  while(val>0) {
                    setBit[k++]-=val&1;
                    val=val>>1;
                }
                i++;
            }}
            return Math.max(max,j-i);
    }
    boolean isNice(int n,int[] setBit){
        int i=0;
        while(n>0){
            if((n&1)==1 && setBit[i]>0) return false;
            n=n>>1;
            i++; 
        }
        return true;
    }
}