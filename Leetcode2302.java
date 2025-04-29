class Solution {
  public long countSubarrays(int[] nums, long k) {
      long count=0;
      long score=0;
      int i=0;
      long sum=0;
      for(int j=0;j<nums.length;j++){
          sum+=nums[j];
          score=sum*(j-i+1);
          if(score<k) continue;
          int c=0;
          while(score>=k){
             c++;
             sum-=nums[i++];
             score=sum*(j-i+1);
          } count+=1L*(nums.length-j)*c;
      } return ((1L*nums.length)*(nums.length+1))/2 - count;
  }
}
