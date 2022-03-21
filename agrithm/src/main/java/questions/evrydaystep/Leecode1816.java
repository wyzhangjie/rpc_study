package questions.evrydaystep;

public class Leecode1816 {
    public String truncateSentence(String s, int k) {
       String[] mid=  s.split(" ");
       StringBuffer stringBuffer = new StringBuffer();
       for(int i=1;i<=k;i++){
           stringBuffer.append(mid[i-1]).append(" ");
       }
        stringBuffer =  stringBuffer.deleteCharAt(stringBuffer.length()-1);
       return stringBuffer.toString();

    }
    public String truncateSentence1(String s, int k) {
        int count =0;
        String result=null;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                count++;
                if(count==k){
                    result= s.substring(0,i);
                    break;
                }
            }
        }
        if(result==null){
            result =s;
        }
        return result;

    }
    public static void main(String[] args) {
        Leecode1816 leecode1816 = new Leecode1816();
        System.out.println( leecode1816.truncateSentence1("Hello how are you Contestant",4));
    }
}
