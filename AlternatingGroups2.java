public class AlternatingGroups2 {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        boolean isEven=(k%2==0);
            int j=1,count=1,i=0,ans=0,len=colors.length;
            while(i<len){
                while(count<k && ((j!=0 && colors[j]!=colors[j-1]) || (j==0 && colors[0]!=colors[len-1]))) {
                    count++;
                    if(count==k) break;
                    j=(j+1)%len;

                }

                if(count==k && ((!isEven && colors[i]==colors[j])||(isEven && colors[i]!=colors[j]))){
                    ans++;
                    i=i+1;
                    j=(j+1)%len;
                }
                else{
                    i=(count==k)?i+count-1:i+count;
                    j=(i+1)%len;
                    count=1;
                }

            }
            return ans;
    }
    
}
