import java.util.HashSet;

public class MaximumEraserValue {
  public int maximumUniqueSubarray(int[] nums) {
        if(nums.length==1) return nums[0];
        int maxScore=0,i=0,j=0,score=0;
        HashSet<Integer> set=new HashSet<>();
        while(j<nums.length){
            while(set.contains(nums[j])){
                set.remove(nums[i]);
                score-=nums[i];
                i++;
            }
            score+=nums[j];
            set.add(nums[j]);
            maxScore=Math.max(score,maxScore);
            j++;
        } return maxScore;
    }
}
