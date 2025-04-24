import java.util.HashMap;
import java.util.HashSet;

public class CompleteSubarray {
   public int countCompleteSubarrays(int[] nums) {
        int count=0,total;
        HashMap<Integer,Integer> map=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        for(int el:nums) set.add(el);
        total=set.size();
        int i=0;
        for(int j=0;j<nums.length;j++){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            int size=map.size();
            int c=0;
            while(size==total){
               c++;
               int val=map.get(nums[i]);
               if(val==1) map.remove(nums[i]);
               else map.put(nums[i],val-1);
               i++;
               size=map.size();
            }
            count+=(nums.length-j)*c;
        } return count;
}}
