import java.util.HashMap;

public class LongestSubarrayWithAtmostTwoDistinctCharacter {
  public int totalElements(int[] arr) {
       int  n=arr.length;
       if(n<2) return 0;
       HashMap<Integer,Integer> map=new HashMap<>();
       int i=0,j=0,max=0;
       while(j<n){
           if(map.size()>2) {
               max=Math.max(max,j-i-1);
               int val=map.get(arr[i]);
               if(val==1) map.remove(arr[i]);
               else map.put(arr[i],val-1);
               i++;
           }
          else {
              map.put(arr[j],map.getOrDefault(arr[j],0)+1);
              j++;
       }
    } return (map.size()>2)?Math.max(max,j-i-1):Math.max(max,j-i);
    }
}
