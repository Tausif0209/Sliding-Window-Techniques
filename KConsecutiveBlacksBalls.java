class Solution {
    public int minimumRecolors(String blocks, int k) {
        int i=0,j=0,white=0,len=blocks.length();
        while(j<k){
          if(blocks.charAt(j++)=='W') white++;
        }
        if(white==0) return 0;
        int min=white;
        while(j<len){
            if(blocks.charAt(i++)=='W') white--;
            if(blocks.charAt(j++)=='W') white++;
            min=Math.min(min,white);
        }
        return min;
    }
}