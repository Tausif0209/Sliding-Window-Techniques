public class Leetcode3 {
   public int lengthOfLongestSubstring(String s) {
        //Brute-Force
    //     int i,j,k,max=0,c=0;String w;
    //     for(i=0;i<s.length();i++)
    //     {
    //         w="";
    //         w=w+s.charAt(i);
    //         for(j=i+1;j<s.length();j++)
    //         {
    //            // w=s.substring(i,j+1);
    //            c=0;
    //            for(k=0;k<w.length();k++)
    //            {
    //             if(w.charAt(k)==s.charAt(j))
    //             {
    //             c++;
    //             break;
    //             }
    //            }
    //             if(c>0)
    //             break;
    //             else
    //              w=w+s.charAt(j);
    //         }
    //         if(w.length()>max)
    //         {
    //             max=w.length();
    //             //ans=i;
    //         }
    //     }
    //    return max; 
      if(s.length()==0) return 0;
      boolean[] flag=new boolean[95];
      int max=1,len=s.length();
      int i=0,j=0;
      while(j<len){
        if(!flag[s.charAt(j)-' ']){
        flag[s.charAt(j++)-' ']=true;
        continue;
        }  
        max=Math.max(max,j-i);
        while(flag[s.charAt(j)-' ']) flag[s.charAt(i++)-' ']=false;
        flag[s.charAt(j)-' ']=true;
        j++;
      } return Math.max(max,j-i);
    }
}
