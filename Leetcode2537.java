import java.util.HashMap;

public class Leetcode2537 {
    public long countGood(int[] nums, int k) {
        if(nums.length<2) return 0;
        long ans=0;
        int i=0,j=0,pairs=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(j<nums.length){
            int val=map.getOrDefault(nums[j],0);
            pairs+=val;
            map.put(nums[j],val+1);
            int count=0;
            while(pairs>=k){
               map.put(nums[i],map.get(nums[i])-1);
               pairs-=map.get(nums[i++]);
               count++;
            }
            ans+=((long)count)*(nums.length-j);
            j++;
        }
        return ans;
    }
    
}
