public class Permutation {
  public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] fre=new int[26];
        for(char ch:s1.toCharArray()){
            fre[ch-'a']++;
        }
        String targetHashCode=findHashCode(fre);
        fre=new int[26];
        int i;
        for(i=0;i<s1.length();i++){
            fre[s2.charAt(i)-'a']++;
        }
        if(findHashCode(fre).equals(targetHashCode)) return true;
        i=0;
        for(int j=s1.length();j<s2.length();j++,i++){
            fre[s2.charAt(j)-'a']++;
            fre[s2.charAt(i)-'a']--;
            if(findHashCode(fre).equals(targetHashCode)) return true;
        } return false;

    }
    private String findHashCode(int[] fre){
       StringBuilder hashCode = new StringBuilder();
        for (int i=0;i<26;i++) {
            if (fre[i] > 0) hashCode.append(fre[i]).append((char) ('a' + i));
        }
        return hashCode.toString();
    }
}
