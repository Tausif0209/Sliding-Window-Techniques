class Solution {
    public int minOperations(int[] nums) {
        int minOp=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1) continue;
            if(i+3>nums.length) return -1;
            minOp++;
            for(int j=i;j<i+3;j++){
                nums[j]^=1;
            }
        }
        return minOp;
    }
}
