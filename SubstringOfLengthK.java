import java.util.HashMap;

public class SubstringOfLengthK {
  public int substrCount(String s, int k) {
        int len=s.length();
        if(k>len) return 0;
        HashMap<Character,Integer> map=new HashMap<>();
        int i,j,count=0;
        char ch;
        for(i=0;i<k;i++){
          ch=s.charAt(i); 
          map.put(ch,map.getOrDefault(ch,0)+1);
        } 
        if(map.size()==k-1) count++;
        j=k;i=0;
        while(j<len){
            ch=s.charAt(j++);
            char ch1=s.charAt(i++);
            map.put(ch,map.getOrDefault(ch,0)+1);
            int val=map.get(ch1);
            if(val==1) map.remove(ch1);
            else map.put(ch1,val-1);
            if(map.size()==k-1) count++;
        } return count;
    }
}
