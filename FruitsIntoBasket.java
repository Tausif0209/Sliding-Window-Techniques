import java.util.HashMap;

public class FruitsIntoBasket {
  public int totalFruit(int[] fruits) {
        if(fruits.length==1) return 1;
        int max=0;
        HashMap<Integer,Integer> frequency=new HashMap<>();
        int i=0,j=0;
        while(j<fruits.length){
            frequency.put(fruits[j],frequency.getOrDefault(fruits[j],0)+1);
            while(frequency.size()>2){
                int val=frequency.get(fruits[i]);
                if(val==1) frequency.remove(fruits[i]);
                else frequency.put(fruits[i],val-1);
                i++;
            } 
            max=Math.max(max,j-i+1);
            j++;
        } return max;
    }
}
