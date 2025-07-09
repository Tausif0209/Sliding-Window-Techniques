import java.util.ArrayList;

public class Leetcode3439 {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
    int total=0;//total free time
    int n=startTime.length;
    ArrayList<Integer> freeTimes=new ArrayList<>();
    int i;
    for(i=0;i<n;i++){
        int freeTime=(i==0)?(startTime[i]):(startTime[i]-endTime[i-1]);
        total+=freeTime;
        freeTimes.add(freeTime);
    }
        total+=eventTime-endTime[i-1];
        freeTimes.add(eventTime-endTime[i-1]);
    int size=freeTimes.size();
    if(size<=k) return total;
    int[] prefixSum=new int[size];
    for(i=size-1;i>=0;i--) prefixSum[i]=(i==size-1)?total: prefixSum[i+1]-freeTimes.get(i+1);
    int j=k,ans=0;i=0;
    while(j<size){
        ans=Math.max(ans,(i==0)?prefixSum[j]:prefixSum[j]-prefixSum[i-1]);
        i++;j++;
    } 
    return ans;
    }
}
