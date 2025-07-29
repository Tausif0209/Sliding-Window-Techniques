public class Leetcode2411 {
   public int[] smallestSubarrays(int[] nums) {
        if(nums.length==1) return new int[]{1};
        int[] fre=new int[32];
        int[] maxOrFre=new int[32];
        for(int el:nums) updateFrequency(el,maxOrFre,true);
        int[] ans=new int[nums.length];
        int i=0,j=0;
        while(j<nums.length){
            updateFrequency(nums[j],fre,true);
            while(getOr(fre)==getOr(maxOrFre) && i<=j){
                ans[i]=j-i+1;
                updateFrequency(nums[i],fre,false);
                updateFrequency(nums[i],maxOrFre,false);
                i++;
            } j++;
        } return ans;
    }
    private void updateFrequency(int n,int[] fre,boolean isIncrease){
        int i=0;
        while(n>0){
           if(n%2==1){
            if(isIncrease) fre[i]++;
            else fre[i]--;
           }
           i++;
           n>>=1;
        }
    }
    private int getOr(int[] fre){
        int or=0;
        for(int i=0;i<32;i++){
           if(fre[i]>=1) or|=1<<i;
        } return or;
    }
}
