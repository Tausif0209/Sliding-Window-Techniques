import java.util.HashMap;
import java.util.HashSet;

public class SmallestWindowContainingAllCharacter {
  public static String smallestWindow(String s, String p) {
        if(s.length()<p.length()) return "";
        int minLength=Integer.MAX_VALUE;
        String ans="";
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        HashSet<Character> set=new HashSet<>();
        for(char ch:p.toCharArray()){
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        } 
        int i=0,j=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(!map2.containsKey(ch)){
                j++;
                continue;
            } 
            map1.put(ch,map1.getOrDefault(ch,0)+1);
            if(map1.get(ch)>=map2.get(ch)) set.add(ch);
            while(set.size()==map2.size()){
                if(j-i+1<minLength) {
                    minLength=j-i+1;
                    ans=s.substring(i,j+1);
                }
                char ch1=s.charAt(i);
                if(map2.containsKey(ch1)) {
                    map1.put(ch1,map1.get(ch1)-1);
                    if(map1.get(ch1)<map2.get(ch1)) set.remove(ch1);
                }
                i++;
            }
         j++;
        } return ans;
    }
}
