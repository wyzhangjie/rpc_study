package questions.evrydaystep;

public class Leecode1332 {

    public int removePalindromeSub(String s) {
        int len = s.length()/2;
        for(int i=0;i<len;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return 2;
            }
        }
        return 1;
    }

}
