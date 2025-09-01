import java.util.HashMap;
import java.util.PriorityQueue;

public class SumOfMode {
      public int sumOfModes(int[] arr, int k) {
       if(arr.length==1) return arr[0];
       HashMap<Integer,Integer> frequency=new HashMap<>();
       int i;
       PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
           int cmp=b[1]-a[1];
           return cmp==0?a[0]-b[0]:cmp;
       });
       for(i=0;i<k;i++) {
           frequency.put(arr[i],frequency.getOrDefault(arr[i],0)+1);
       }
       for(Integer key:frequency.keySet()){
           pq.offer(new int[]{key,frequency.get(key)});
       }
       int sum=pq.peek()[0];
       int j=0;
       while(i<arr.length){
           int val1=frequency.getOrDefault(arr[i],0);
           frequency.put(arr[i],val1+1);
           int val2=frequency.get(arr[j]);
           frequency.put(arr[j],val2-1);
           pq.offer(new int[]{arr[i],val1+1});
           pq.offer(new int[]{arr[j],val2-1});
           while(pq.peek()[1]!=frequency.get(pq.peek()[0])) pq.poll();
           sum+=pq.peek()[0];
           i++;
           j++;
       } return sum;
    }
  
}
