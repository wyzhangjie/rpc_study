package questions.weekcontent;

/**
 * ClassName Leecode5994
 * Description
 * Create by jie.zhang02
 * Date 2022/1/30 12:01 下午
 */
public class Leecode5994 {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        Long[] preLong = new Long[k];
        //预处理每一个位置的次方
        preLong[0]=1L;
        for(int i=1;i<k;i++){
            preLong[i]= (preLong[i-1]*power)%modulo;
        }
        for(int i=0;i<s.length()-k+1;i++){

            if(hasValueMethod(s.substring(i,k+i),modulo,hashValue,preLong)){
                return s.substring(i,k+i);
            }
        }
        return null;
    }

    private boolean hasValueMethod(String substring, int modulo, int hashValue,Long[] preLong ) {
        Long result=0L;
        for(int i=0;i<substring.length();i++){
            result=(result+ (substring.charAt(i)-'a'+1)*preLong[i])%modulo;
        }
        if(result%modulo==hashValue){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        //"xmmhdakfursinye"
        //96
        //45
        //15
        //21
      String  s = "xmmhdakfursinye";
      int power = 96, modulo = 45, k = 15, hashValue = 21;
        Leecode5994 leecode5994 = new Leecode5994();
        System.out.println(leecode5994.subStrHash(s,power,modulo,k,hashValue));
    }
}
