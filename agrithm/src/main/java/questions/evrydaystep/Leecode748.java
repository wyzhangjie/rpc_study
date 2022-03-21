package questions.evrydaystep;

public class Leecode748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] chars = new int[26];
        for(char a :licensePlate.toCharArray()){
            if(Character.isLetter(a) ){
                chars[Character.toLowerCase(a)-'a']++;
            }
        }
        String ans=null;

        for(String tt:words){
            int[] temp = new int[26];
            for(char a :tt.toCharArray()){
                temp[Character.toLowerCase(a)-'a']++;
            }
            boolean flag= true;
            for(int i=0;i<26;i++){
                if(temp[i]<chars[i]){
                    flag=false;
                    break;
                }
            }
            if(flag ){
                if(ans==null){
                    ans = tt;
                }else if(tt.length()<ans.length()){
                    ans=tt;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        Leecode748 leecode748 = new Leecode748();
        String ans=   leecode748.shortestCompletingWord("1s3 456",new String[]{"looks", "pest", "stew", "show"});
        System.out.println(ans);
    }
}
