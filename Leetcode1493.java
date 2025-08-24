public class Leetcode1493 {
      public int longestSubarray(int[] nums) {
        if(nums.length==1) return 0;
        int i=0,j,countZero=0,max=-1;
        for(j=0;j<nums.length;j++){
            if(nums[j]==1) continue;
            countZero++;
            max=Math.max(max,j-i-1);
            while(countZero==2){
                if(nums[i++]==0) countZero--;
            }
        }
        return countZero==0?nums.length-1:Math.max(max,j-i-1);
    }
}
