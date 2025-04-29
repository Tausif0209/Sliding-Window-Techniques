class Solution {
  public long countSubarrays(int[] nums, int k) {
      int max=findMax(nums);
      int count=0;
      long ans=0;
      int i=0;
      for(int j=0;j<nums.length;j++){
          if(nums[j]!=max) continue;
          count++;
          int c=0;
          while(count>=k) {
              c++;
              if(nums[i]==max) count--;
              i++;
          } ans+=1L*(nums.length-j)*c;
      } return ans;
  }
  private int findMax(int[] nums) {
      int max=nums[0];
      for(int el:nums) max=Math.max(max,el);
      return max;
  }
}