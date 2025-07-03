public class LongestSubstrinngWithKdistinctCharacter {
   public int longestKSubstr(String s, int k) {
        int len=s.length();
        if(k>len) return -1;
        int i=0,j=0,max=-1,distinct=0;
        int[] count=new int[26];
        while(j<len){
            if(count[s.charAt(j)-'a']++==0) distinct++;
            if(distinct==k) max=Math.max(max,j-i+1);
            while(distinct>k){
                if(--count[s.charAt(i++)-'a']==0) distinct--;
            }
            j++;
        } return max;
    }
}
